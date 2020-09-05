package algorithms;

import main.*;
import operators.*;

import java.util.Stack;

public class DFS_L<T> extends Searcher<T> {
	private Stack<Node<T>> open;
	private int lim;

	public DFS_L(Operators<T>[] operators, int lim) {
		super(operators);
		this.open = new Stack<>();
		this.lim = lim;
	}


	@Override
	public void addSuccessors(Node<T> node) {
		for (int i = this.operators.length - 1; i >= 0; i--) {//Opposite order because of stack
			T curState = node.getState();
			T nextState = this.operators[i].doMove(curState);
			if (nextState != null) {
				Node<T> next = new Node<T>(nextState, this.operators[i].toString(), node, node.getDepth() + 1);
				if (!this.close.contains(next) && !this.open.contains(next)) {	
					this.open.push(next);
				}
			}
		}
	}

	@Override
	public String solve(Node<T> init, Node<T> goal) {
		this.close.clear();
		this.open.clear();
		this.open.push(init);
		while (!this.open.isEmpty()) {
			Node<T> v = this.open.pop();
			if (v.equals(goal))
				return this.path(v);
			this.close.add(v);
			if (v.getDepth() < this.lim)
				this.addSuccessors(v);

		}
		return "No solution";
	}
}