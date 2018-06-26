package linkedlist;

/**
 * Remove Dups: Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class RemoveDups {



    //with buffer
//    void deleteDups (LinkedListNode n){
//        HashSet<Integer> set = new HashSet<>();
//        LinkedListNode previous = null;
//        while (n != nUll) {
//            if (set.contains(n.data)) {
//                previous.next = n.next;
//            } else {
//                set.add(n.data);
//                previous = n;
//            }
//            n = n.next;
//        }
//    }

    //without buffer
    //If we don't have a buffer, we can iterate with two pointers: cu rrent which iterates through the linked list,
    //and runner which checks all subsequent nodes for duplicates.
    void deleteDups(LinkedListNode head){
        LinkedListNode current = head;
        while(current != null){
            //remove all future nodes that have same value
            LinkedListNode runner = current;
            while (runner.next != null) {
                if(current.data == runner.next.data){
                    runner.next = runner.next.next;
                }else{
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}
