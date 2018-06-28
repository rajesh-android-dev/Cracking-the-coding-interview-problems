package StacksAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
 * threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
 * composed of several stacks and should create a new stack once the previous one exceeds capacity.
 * SetOfStacks. push () and SetOfStacks. pop() should behave identically to a single stack
 * (that is, pop ( ) should return the same values as it would if there were just a single stack).
 */
public class StackOfPlates {
    ArrayList<CustomStack> stacks = new ArrayList<>();
    public int capacity = 7;

    public void push(int value)

    {
        CustomStack last = getLastStack();
        if (last != null && !last.isFull()) {
            last.push(value);
        } else {
            CustomStack stack = new CustomStack(capacity);
            stack.push(value);
            stacks.add(stack);
        }
    }

    public int pop() {
        CustomStack last = getLastStack();
        if (last == null) throw new EmptyStackException();
        int v = last.pop();
        if (last.size == 0) stacks.remove(stacks.size() - 1);
        return v;
    }

    public CustomStack getLastStack() {
        if (stacks.size() == 0) return null;
        return stacks.get(stacks.size() - 1);
    }
}

class CustomStack extends Stack {
    public int capacity;
    public int size;

    public CustomStack(int capacity) {
        this.capacity = capacity;
    }

    public void push(int value) {
        size++;
        super.push(value);
    }

    public Integer pop() {
        int value = this.pop();
        size--;
        return value;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}