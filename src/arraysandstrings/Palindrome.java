package arraysandstrings;

import linkedlist.LinkedListNode;

import java.util.Stack;

/**
 * Palindrome: Implement a function to check if a linked list is a palindrome.
 */
public class Palindrome {

    //--------------------------------------------- 1. REVERSE AND COMPARE ---------------------------------------------
    /**
     * Reverse the list and check if both values in the list are same
     *
     * @param original
     * @return
     */
    boolean isPalindrome(LinkedListNode original) {
        LinkedListNode reversed = reverseList(original);
        return isEqual(original, reversed);
    }

    private boolean isEqual(LinkedListNode original, LinkedListNode reversed) {
        if (original != null && reversed != null) {
            if (original.data != reversed.data) {
                return false;
            }
            original = original.next;
            reversed = reversed.next;
        }
        return original == null && reversed == null;
    }

    private LinkedListNode reverseList(LinkedListNode node) {
        LinkedListNode head = null;
        while (node != null) {
            LinkedListNode n = new LinkedListNode(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    //---------------------------------------------- 2. ITERATIVE APPROACH ---------------------------------------------

    /**
     *
     * @param head
     * @return
     */
    boolean isPalindromeIt(LinkedListNode head){
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        Stack<Integer> stack = new Stack<>();
        //push the first half of the list inta stack
        while (fast != null && fast.next != null){
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        //odd number of elements, so omit the centre element
        if (fast != null){
            slow = slow.next;
        }

        //compare the first half in stack is equal to the last half
        while (slow != null){
            if (slow.data != stack.pop()){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
