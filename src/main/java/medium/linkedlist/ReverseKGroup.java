package medium.linkedlist;

public class ReverseKGroup {

    public static void main(String[] args) {

    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode node = head;
        int count = 0;
        while (node != null && count < k) {
            node = node.next;
            count++;
        }
        if (count < k) return head; // fewer than k nodes left, leave as-is

        ListNode prev = reverseKGroup(node, k); // recurse on the remainder first
        ListNode curr = head;
        while (count-- > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
