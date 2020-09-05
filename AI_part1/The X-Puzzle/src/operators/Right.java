package operators;

import java.util.Arrays;
import main.Board;


public class Right extends Operators<Board> {

    public Right() {
        super("R");
    }

    @Override
    public Board doMove(Board state) {
        
        if (0==state.getEmptyC())
            return null;
        
    	int[][] board = state.getBoard();
    	int[][] matx = new int[board.length][board[0].length];
    	
    	for(int i=0; i<board.length; i++)
            matx[i] = Arrays.copyOf(board[i], board.length);
   
        matx[state.getEmptyR()][state.getEmptyC()] = matx[state.getEmptyR()][state.getEmptyC()-1];
        matx[state.getEmptyR() ][state.getEmptyC()- 1] = 0;

        return new Board(matx,state.getEmptyR(),state.getEmptyC()- 1);
    }
}
