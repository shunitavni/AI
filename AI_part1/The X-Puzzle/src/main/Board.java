package main;


import java.util.Arrays;

public class Board {
    private int[][] board;
    private int emptyR;
    private int emptyC;
    private String state;

    public Board(int[][] board, int row, int col) {
        this.board = board;
        this.emptyR = row;
        this.emptyC = col;
        StringBuilder tmp = new StringBuilder();
        for (int t = 0;t<this.board.length;t++) {
            for (int i = 0;i<this.board[0].length;i++) {
                tmp.append(String.format("%d-", this.board[t][i]));
            }
        }
        state = tmp.toString();
    }

    public String getState() {
    	return this.state;
    }
    
    public Board copy() {
        int len = board.length;
        int[][] tmp = new int[len][len];
        for (int i = 0; i < len; i++) {
            tmp[i] = Arrays.copyOf(board[i], len);
        }
        return new Board(tmp, this.emptyR, this.emptyC);
    }

    public int[][] getBoard() {
        return board;
    }

    public int getEmptyR() {
        return emptyR;
    }

    public int getEmptyC() {
        return emptyC;
    }

    public void setEmptyR(int row) {
        this.emptyR = row;
    }
    
    public void setEmptyC(int col) {
        this.emptyC = col;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Board otherBoard = (Board) o;
        return this.getState().equals(otherBoard.getState());
    }



    public void print() {
        for (int[] row : this.board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
