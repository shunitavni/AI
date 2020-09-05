package algorithms;

import main.Node;
import operators.Operators;
import java.util.HashSet;
import java.util.Set;

public abstract class Searcher<T> {
	
    protected Set<Node<T>> close;
    protected Operators<T>[] operators;
    final protected String didNotFindSolution = "No solution found";

    public Searcher(Operators<T>[] operators) {
        this.close = new HashSet<>(); // in HashSet we are passing only one value in our case HashSet of Nodes.
        this.operators = operators;
    }

    
    //Create all the reachable states (our offsprings) from the current state.
    public abstract void addSuccessors(Node<T> node);


    public abstract String solve(Node<T> init, Node<T> goal);

    //Calculate path trace back.
    protected String path(Node<T> node) {
    	//tmp eventually will represent the total and best path achieved by the algorithm.
        StringBuilder tmp = new StringBuilder();
        Node<T> cameFrom = node.getCameFrom();
        while (cameFrom != null) {
            tmp.insert(0, node.getOp());
            node = cameFrom;
            cameFrom = node.getCameFrom();
        }
        return tmp.toString();
    }
}
