package TreesAndGraphs.BuildOrder;

import java.util.ArrayList;
import java.util.Stack;

public class BuildOrder {

    Stack<Project> findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    private Stack<Project> orderProjects(ArrayList<Project> nodes) {
        Stack<Project> stack = new Stack<>();
        for (Project project : nodes) {
            if (project.getState() == Project.State.BLANK) {
                if (!doDFS(project, stack)) {
                    return null;
                }
            }
        }
        return stack;
    }

    private boolean doDFS(Project project, Stack<Project> stack) {
        if (project.getState() == Project.State.PARTIAL) {
            return false; //cycle
        }

        if (project.getState() == Project.State.BLANK) {
            project.setState(Project.State.PARTIAL);
            ArrayList<Project> children = project.getChildren();
            for (Project child : children) {
                if (!doDFS(child, stack)) {
                    return false;
                }
            }
            project.setState(Project.State.COMPLETE);
            stack.push(project);
        }
        return true;
    }

    Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();

        for (String project : projects) {
            graph.getOrCreateNode(project);
        }

        for (String[] dependecy : dependencies) {
            String first = dependecy[0];
            String second = dependecy[1];
            graph.addEdge(first, second);
        }

        return graph;
    }
}
