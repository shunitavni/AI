package algorithms;


import java.util.HashMap;
import java.util.Map;

import main.Board;

//Manhattan distance
public class ManhattanDist implements HeuristicFunc<Board> {
    private Map<Integer, int[]> goalStateMap;
    
    //Save indexes to reduce computations.
    public void setGoalStateMap(Board goalState) {
    	goalStateMap = new HashMap<>();
        int[][] myBoard = goalState.getBoard();
        for (int i = 0; i < goalState.getBoard().length; i++) {
            for (int j = 0; j < goalState.getBoard()[0].length; j++) {
            	goalStateMap.put(myBoard[i][j], new int[]{i, j});
            }
        }
    }

    public int dist(Board boardState) {
        int[][] myBoard = boardState.getBoard();
        int totalDis = 0;
        for (int i = 0; i < boardState.getBoard().length; i++) {
            for (int j = 0; j < boardState.getBoard()[0].length; j++) {
                int num = myBoard[i][j];
                int[] goalIndexes = goalStateMap.get(num);
                int goalX = goalIndexes[0];
                int goalY = goalIndexes[1];
                totalDis += Math.abs(i - goalX) + Math.abs(j - goalY);
            }
        }
        return totalDis;
    }

}

