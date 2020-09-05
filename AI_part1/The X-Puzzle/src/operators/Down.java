package operators;

import main.Board;
import java.util.Arrays;

public class Down extends Operators<Board> {

    public Down() {
        super("D");
    }

    @Override
    public Board doMove(Board state) {
        //saving current state
    	int[][] board = state.getBoard();
    	
    	//check boundaries 
        if (state.getEmptyR() == 0)
            return null;
        
        //create new node that will represent the "Down" offspring state connected to this current state.
    	int[][] matx = new int[board.length][board[0].length];
    	
    	//Initiate our new node/state with the current node/state values using Arrays.copyOf method.
    	for(int i=0; i<board.length; i++)
            matx[i] = Arrays.copyOf(board[i], board.length);
    	
    	//here we implement the Down operator by moving Down the value in the index which is above the empty space in the current state
        matx[state.getEmptyR()][state.getEmptyC()] = matx[state.getEmptyR() - 1][state.getEmptyC()];
        //Place zero instead of the value we swapped in the above line
        matx[state.getEmptyR() - 1][state.getEmptyC()] = 0;
        
        //returning the new state with the new emptyR + emptyC
        return new Board(matx,state.getEmptyR() - 1,state.getEmptyC());
    }
}