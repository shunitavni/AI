package algorithms;


public interface HeuristicFunc<T> {
    public void setGoalStateMap(T goalState);
    public int dist(T boardState);

}
