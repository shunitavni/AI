package main;

public class Node<T> {
	private T state;
	private Node<T> cameFrom;
	private int depth;
	private String op;
	public Node(T state,String o,Node<T> cameFrom,int depth) {
		this.state = state;
		this.cameFrom = cameFrom;
		this.depth = depth;
		this.op = o;
	}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<T> node = (Node<T>) o;
        return this.state.equals(node.state);
    }
	
	public int getDepth() {
		return this.depth;
	}
	
	public T getState() {
		return this.state;
	}
	public Node<T> getCameFrom() {
		return cameFrom ;
	}
	public void setCameFrom(Node<T> s) {
		this.cameFrom = s;
	}
	public String getOp() {
		return op;
	}

}