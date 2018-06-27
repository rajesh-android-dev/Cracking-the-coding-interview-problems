package linkedlist;

/**
 * Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the
 * intersecting node. Note that the intersection is defined based on reference, not value. That is, if the
 * kth node of the first linked list is the exact same node (by reference) as the jth node of the second
 * linked list, then they are intersecting.
 */
public class Intersection {
    /**
     * 1. Run through each linked list to get the lengths and the tails.
     * 2. Compare the tails. If they are different (by reference, not by value), return immediately. There is no intersection.
     * 3. Set two pointers to the start of each linked list.
     * 4. On the longer linked list, advance its pointer by the difference in lengths.
     * 5. Now, traverse on each linked list until the pointers are the same.
     * @param list1
     * @param list2
     * @return
     */
    LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2){
        Result result1 = getLengthAndTail(list1);
        Result result2 = getLengthAndTail(list2);

        if (result1.tail != result2.tail)
            return null;

        LinkedListNode shorter = result1.length < result2.length ? list1 : list2;
        LinkedListNode longer = result1.length < result2.length ? list2 : list1;

        longer = gotoKthNode(longer,Math.abs(result1.length - result2.length));

        //traverse until the two nodes aren't same
        while (longer != shorter){
            longer = longer.next;
            shorter = shorter.next;
        }

        //return any one node
        return longer;
    }

    Result getLengthAndTail(LinkedListNode list){
        int length = 1;
        LinkedListNode node = list;
        while (node.next != null){
            length++;
            node = node.next;
        }
        Result result = new Result(length,node);
        return result;
    }

    LinkedListNode gotoKthNode(LinkedListNode list, int k){
        LinkedListNode node = list;
        while (k > 0 && node != null){
            node = node.next;
            k--;
        }
        return node;
    }

    public class Result {
        public int length;
        public LinkedListNode tail;

        public Result(int length, LinkedListNode tail){
            this.length = length;
            this.tail = tail;
        }
    }
}
