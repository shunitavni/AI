package main;

import algorithms.*;
import operators.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	for(int p = 1 ;p<=10;p++) {
		String srcFile = "input" + String.valueOf(p) + ".txt";
		String destFile = "output" + String.valueOf(p) + ".txt";
        int algorithmIndex; // Algorithm number: 1-IDS, 2-BFS , 3-AStar.
        int n; //board size
        
        //both indicate the empty index
        int emptyRowIdx = 0;
        int emptyColidx = 0;

        //measure time
        long startTime = 0;
        long finishTime = 0;
        
        Searcher<Board> searchAlgorithm = null;
        
        // The operators, organized by priority as requested.
        Operators<Board>[] operators = new Operators[]{new Up(), new Down(), new Left(), new Right()};

        //Reading from input.txt first line which indicate the algorithm number.
        try {
            Scanner scanner = new Scanner(new FileInputStream(srcFile));
            algorithmIndex = Integer.parseInt(scanner.nextLine());
            switch (algorithmIndex) {
                case 1:
                    searchAlgorithm = new IDS<>(operators, 100);
                    break;
                case 2:
                    searchAlgorithm = new BFS<>(operators);
                    break;
                case 3:
                    HeuristicFunc<Board> heuristicFunc = new ManhattanDist();
                    searchAlgorithm = new AStar<>(operators, heuristicFunc);
                    break;

                default:
                    System.out.println("Wrong algorithm input! Number must be 1-main.Algorithms.IDS,2-main.Algorithms.BFS or 3-A*.");
                    System.exit(-1);
                    break;
            }

            //Read next line from input.txt so we can set initial and goal board state.
            n = Integer.parseInt(scanner.nextLine());
            scanner.useDelimiter("-");
            int[][] startBoard = new int[n][n];
            int[][] goalBoard = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                	startBoard[i][j] = scanner.nextInt();
                    if (startBoard[i][j] == 0) {
                        emptyRowIdx = i;
                        emptyColidx = j;
                    }
                    goalBoard[i][j] = i * n + j + 1;

                }
            }
            //initiate the last index in the array with the value - zero which indicate the supposed empty state (goal state)
            goalBoard[n - 1][n - 1] = 0;

            //create both current and goal state 
            Node<Board> start = new Node<>(new Board(startBoard, emptyRowIdx, emptyColidx), null, null,0);
            Node<Board> goal = new Node<>(new Board(goalBoard, n - 1, n - 1), null, null,0);
            
            startTime = System.currentTimeMillis();
            String solution = searchAlgorithm.solve(start, goal);
            finishTime = System.currentTimeMillis();

            //print the path solution to ootput.txt file
            try {
                PrintWriter writer = new PrintWriter(destFile);
                writer.println(solution);
                writer.close();
                System.out.println(String.format("The solution is in file %s", destFile));
                System.out.println("Execution Time: " + (finishTime-startTime));
            } catch (IOException e) {
                System.out.println(String.format("Failed to open file. The solution is: %s", solution));
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist. Please try again.");
        }
    }
    }
}