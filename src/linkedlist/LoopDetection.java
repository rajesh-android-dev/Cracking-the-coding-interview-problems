package linkedlist;

/**
 * Given a circular linked list, implement an algorithm that returns the node at the
 * beginning of the loop.
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
 * as to make a loop in the linked list.
 * EXAMPLE
 * Input: A -) B -) C -) 0 -) E - ) C[thesameCasearlierl
 * Output: C
 */
public class LoopDetection {
    /**
     * 1. Create two pointers, FastPointer and SlowPointer.
     * 2. Move FastPointer at a rate of 2 steps and SlowPointer at a rate of 1 step.
     * 3. When they collide, move SlowPointer to LinkedListHead. Keep FastPointer where it is.
     * 4. Move SlowPointer and FastPointer at a·rate of one step. Return the new collision point.
     *
     * @param head
     * @return
     */
    LinkedListNode findBegining(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        /* find meeting point, this will be LOOP_SIZE - K steps into the linked list*/
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) //collision
                break;
        }

        /* no meeting point, so no loops */
        if (fast == null || fast.next == null)
            return null;

        /* Move slow to the head, keep the fast at the meeting point. Each are k steps from the loop start.
         * If they move at the same pace, they must meet at the loop start*/
        slow = head;
        while (slow == fast) {
            slow = slow.next;
            fast = fast.next;
        }

        /* both point to the loop start */
        return fast;
    }
}
