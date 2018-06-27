package linkedlist;

/**
 * Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
 * before all nodes greater than or equal to x. lf x is contained within the list, the values of x only need
 * to be after the elements less than x (see below). The partition element x can appear anywhere in the
 * "right partition"; it does not need to appear between the left and right partitions.
 * EXAMPLE
 * Input: 3 -> 5 -> 8 -> 5 - > 10 -> 2 -> 1 [partition = 5)
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */
public class Partition {

    /**
     * Check only smaller value along the list and move it to the head, we don't have to swap the higher elements, since
     * it mentioned that all nodes less than x come before all nodes greater than x (not in order)
     *
     * @param head
     * @param pivot
     * @return
     */
    private LinkedListNode partitionLL(LinkedListNode head, int pivot) {
        //start from head.next, if it's a lower value we don't have to move it
        //if it's a higher value, it will be swapped when we traverse through a smaller value
        LinkedListNode node = head;
        while (node != null) {
            if (node.data < pivot) {
                node.next = head;
                head = node;
            }
            node = node.next;
        }
        //return the modified head
        return head;
    }
}
