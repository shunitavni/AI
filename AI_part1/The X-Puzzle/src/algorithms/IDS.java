package algorithms;

import main.*;
import operators.*;

/*---------------------------------------------------------------------------------------------------------------------------------------------------------
 *  -------------------------------------------------  Algorithm IDS - General Explanation & Notes ----------------------------------------------------------------
 * 
 * We start from the root vertex we check if it is our target vertex if it isn't our target vertex it means we increase the limit by 1 and restart our algorithm.
 * if we didn't find our goal state again we will run DFS_L when now the limit has increased in 1 means it is 2 - run it up to the second level.
 * As long as we have not found our "target state" we will increase our limit and go down to the depth of the graph.
 *  
 * This algorithm combines the benefits of both breadth search and depth search.
 * This algorithm implemented using DFS_L algorithm, but here we are working in iterative way when in each iteration we increase the limit in 1.
 * The algorithm does not remember previous calculations between the searches other than the depth limit in the previous iteration.
 * IDS algorithm is complete, if the depth of the solution is L then the algorithm will find it in the L iteration.
 * In terms of optimality he finds the shortest solution.
 * Suppose he found an L-length solution there could not have been a shorter solution otherwise he would have found it in a previous iteration.
 * 
 * ---------------------------------------------------------------------------------------------------------------------------------------------------------
 */

public class IDS<T> extends Searcher<T> {
    private DFS_L<T> dfs;
    private int maxDepth;

    public IDS(Operators<T>[] operators, int maxDepth) {
        super(operators);
        this.maxDepth = maxDepth;
    }


    @Override
    public void addSuccessors(Node<T> node) {
        this.dfs.addSuccessors(node);
    }


    @Override
    public String solve(Node<T> init, Node<T> goal) {
        String result;
        for (int limit = 0; limit <= maxDepth; limit++) {
            this.dfs = new DFS_L<>(operators, limit);
            result = this.dfs.solve(init, goal);
            if (!result.equals("No solution")) {
                return result;
            }
        }
        return "No solution with limit: " + maxDepth;
    }
}
