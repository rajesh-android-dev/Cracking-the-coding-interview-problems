package linkedlist;

/**
 * Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
 * the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
 * that node.
 * EXAMPLE
 * Input: the node c from the linked list a - >b- >c - >d - >e- >f
 * Result: nothing is returned, but the new linked list looks like a - >b- >d - >e- >f
 * Hints: #
 */
public class DeleteMiddleNode {

    /**
     * copy the data from the next node over to the current node, and then to delete the
     * next node.
     *
     * @param node
     * @return
     */
    boolean deleteMiddleNode(LinkedListNode node) {
        if (node == null || node.next == null) {
            return false;
        }
        LinkedListNode node1 = node.next;
        node.data = node1.data;
        node.next = node1.next;
        return true;
    }
}
