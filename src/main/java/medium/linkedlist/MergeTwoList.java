package medium.linkedlist;

public class MergeTwoList {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        ListNode current = result;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;

            } else {
                current.next = l2;
                l2 = l2.next;

            }
            current = current.next;

        }
        if (l1 != null) {
            current.next = l1;
            l1 = l1.next;
        }

        if (l2 != null) {
            current.next = l2;
            l2 = l2.next;
        }

        return  result.next;


    }
}
