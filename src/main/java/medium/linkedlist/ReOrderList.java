package medium.linkedlist;

public class ReOrderList {

    public static void main(String[] args) {

    }


    public void reorderList(ListNode head) {

        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;
        // Step 1: Find the middle of the linked list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Step 2: Reverse the second half of the list
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;

        }
        // Step 3: Merge the two halves
        ListNode first = head;
        ListNode second = prev;
        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;


        }


    }


}
