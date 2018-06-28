package arraysandstrings.StacksAndQueues;

import java.util.EmptyStackException;

/**
 * Three in One: Describe how you could use a single array to implement three stacks.
 */
public class ThreeInOne {
    private int stackCapacity;
    private int numOfStacks = 3;
    private int[] values;
    private int[] sizes;

    public ThreeInOne(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackCapacity * numOfStacks];
        sizes = new int[numOfStacks];
    }

    public void push(int stackNUm, int value) throws Exception {
        if (isFull(stackNUm)) throw new Exception("Stack is full");

        sizes[stackNUm]++;
        values[stackNUm] = value;
    }

    public int pop(int stackNum){
        if (isEmpty(stackNum)) throw new EmptyStackException();

        sizes[numOfStacks]--;
        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];
        values[topIndex] = 0;
        return value;
    }

    public int peek(int stackNum){
        if (isEmpty(stackNum)) throw new EmptyStackException();

        return values[indexOfTop(stackNum)];
    }

    private boolean isFull(int stackNUm) {
        return sizes[stackNUm] == stackCapacity;
    }

    private boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    private int indexOfTop(int stackNum) {
        int offset = stackCapacity * stackNum;
        int size = sizes[stackNum];
        return offset + size - 1;
    }
}
