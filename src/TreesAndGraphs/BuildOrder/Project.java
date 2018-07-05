package TreesAndGraphs.BuildOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Project {

    private ArrayList<Project> children = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();
    private String name;

    public enum State {COMPLETE, PARTIAL, BLANK;}

    private State state = State.BLANK;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Project(String name) {
        this.name = name;
    }

    public void addNeighbor(Project node) {
        if (!map.containsKey(node.getName())) {
            children.add(node);
            map.put(node.getName(), node);
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Project> getChildren() {
        return children;
    }
}
