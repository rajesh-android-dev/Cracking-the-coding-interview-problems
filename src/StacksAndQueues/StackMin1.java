package StacksAndQueues;

import java.util.Stack;

/**
 * Stack Min: How would you design a stack which, in addition to push and pop, has a function min
 * which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 */
public class StackMin1 extends Stack<Integer> {
    public Stack<Integer> s2;

    public StackMin1() {
        s2 = new Stack<>();
    }

    public void push(int value) {
        if (value < min()) {
            s2.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == min()) s2.pop();
        return value;
    }

    public int min() {
        if (s2.isEmpty()) return Integer.MAX_VALUE;
        else return s2.peek();
    }
}
