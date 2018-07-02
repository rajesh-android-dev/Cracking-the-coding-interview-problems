package StacksAndQueues;

import java.util.Stack;

/**
 * Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.
 */

//----Solution----

/**
 * In this approach, stackNewest has the newest elements on top and stackOldest has the oldest
 * elements on top. When we dequeue an element, we want to remove the oldest element first, and so we
 * dequeue from stackOldest. If stackOldest is empty, then we want to transfer all elements from
 * stackNewest into this stack in reverse order. To insert an element, we push onto stac kNewest, since it
 * has the newest elements on top.
 *
 * @param <T>
 */
public class QueueUsing2Stacks<T> {
    private Stack<T> stackOldest, stackNewest;

    public QueueUsing2Stacks() {
        stackOldest = new Stack<>();
        stackNewest = new Stack<>();
    }

    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T value) {
        stackNewest.push(value);
    }

    private void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T peek() {
        shiftStacks();
        return stackOldest.peek();
    }

    public T remove() {
        shiftStacks();
        return stackOldest.pop();
    }
}
