package medium.linkedlist;

public class CopyListwithRandomPointer {


    public static void main(String[] args) {

    }

    public ListNode copyRandomList(ListNode head) {


        ListNode l1 = head;

        //clone nodes inline
        while (l1 != null) {
            ListNode l2 = new ListNode(l1.val);
            l2.next = l1.next;
            l1.next = l2;
            l1 = l2.next;

        }
        //Assign random pointers
        l1 = head;
        while (l1 != null) {
            if (l1.random != null) {
                l1.next.random = l1.random.next;
            }
            l1 = l1.next.next;
        }

        //Separate the two lists
        l1 = head;
        while (l1 != null) {
            ListNode l2 = l1.next;
            l1.next = l2.next;
            if (l2.next != null) {
                l2.next = l2.next.next;
            }
            l1 = l1.next;
        }

        //Return the new head
        ListNode newHead = head.next;
        return newHead;


    }
}
