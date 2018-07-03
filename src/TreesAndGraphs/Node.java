package TreesAndGraphs;

public class Node {
    public String name;
    public Node[] children;
    public RoutesBWNodes.State state;

    public Node[] getAdjacent() {
        return children;
    }
}