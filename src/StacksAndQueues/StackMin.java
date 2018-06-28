package StacksAndQueues;

import java.util.Stack;

/**
 * Stack Min: How would you design a stack which, in addition to push and pop, has a function min
 * which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 */
public class StackMin extends Stack<NodeWithin> {
    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new NodeWithin(value, newMin));
    }

    private int min() {
        if (this.isEmpty()) return Integer.MAX_VALUE;
        else return peek().min;
    }
}

class NodeWithin {
    public int value;
    public int min;

    public NodeWithin(int v, int min) {
        value = v;
        this.min = min;
    }
}