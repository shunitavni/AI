package operators;

import main.Board;

import java.util.Arrays;

public class Left extends Operators<Board> {

    public Left() {
        super("L");
    }

    @Override
    public Board doMove(Board state) {
    	//saving current state
    	int[][] board = state.getBoard();
    	
    	//check boundaries 
        if ((board[0].length-1)==state.getEmptyC()) {
            return null;
        }
        
        //create new node that will represent the "Left" offspring state connected to this current state.
    	int[][] matx = new int[board.length][board[0].length];
    	
    	//Initiate our new node/state with the current node/state values using Arrays.copyOf method.
    	for(int i=0; i<board.length; i++)
            matx[i] = Arrays.copyOf(board[i], board.length);
        
    	//implement Left operator by moving Left the value in the index which is on the right of the empty space in the current state array.
        matx[state.getEmptyR()][state.getEmptyC()] = matx[state.getEmptyR()][state.getEmptyC()+1];
        //Place zero instead of the value we swapped in the above line.
        matx[state.getEmptyR() ][state.getEmptyC()+ 1] = 0;

        //returning the new state with the new emptyR + emptyC.
        return new Board(matx, state.getEmptyR(), state.getEmptyC()+ 1);
    }
}
