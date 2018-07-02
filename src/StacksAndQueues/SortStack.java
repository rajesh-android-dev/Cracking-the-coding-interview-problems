package StacksAndQueues;

import java.util.Stack;

/**
 * Write a program to sort a stack such that the smallest items are on the top. You can use
 * an additional temporary stack, but you may not copy the elements into any other data structure
 * (such as an array). The stack supports the following operations: push, pop, peek, and isEmpty.
 */

public class SortStack {
    public void sort(Stack<Integer> s1) {
        Stack<Integer> s2 = new Stack<>();
        while (!s1.isEmpty()) {
            /* Insert each element in s1 in sorted order into s2. */
            int tmp = s1.pop();
            while (!s1.isEmpty() && tmp > s2.peek()) {
                s1.push(s2.pop());
            }
            s2.push(tmp);
        }
        /* Copy the elements from s2 back into s1. */
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
}
