package linkedlist;

/**
 * Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class ReturnToKth {

    /**
     * We can use two pointers,
     * pi and p2. We place them k nodes apart in the linked list by putting p2 at the beginning and moving pi
     * k nodes into the list. Then, when we move them at the same pace, pi will hit the end of the linked list after
     * LENGTH - k steps. At that point, p2 will be LENGTH - k nodes into the list, or k nodes from the end.
     *
     * @param head
     * @param k
     * @return
     */
    LinkedListNode returnToKElement(LinkedListNode head, int k) {
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        //Move p1 k nodes to the list
        for (int i = 0; i < k; i++) {
            if (p1 == null)
                return null;
            p1 = p1.next;
        }

        //move p1 and p2 at the same pace, when p1 hits the end p2 at the right element
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
