package operators;

public abstract class Operators<T> {

	public String move;
	
	public Operators (String move) {
		this.move=move;
    }

	@Override
	public String toString() {
		return move;
	}
	
	public abstract T doMove(T board);
}

