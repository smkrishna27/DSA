package medium.linkedlist;

public class PalindromeList {

    static class Node {

        Node next;
        int val;

    }

    public static void main(String[] args) {

    }

    public static boolean palindromeList(Node head) {

        if (head == null)
            return false;

        Node slow = head;
        Node fast = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node reverse =
                reverseList(slow);


        Node p1 = head, p2 = reverse;

        while (p2 != null) {
            if (p1.val != p2.val) return false;

            p1 = p1.next;
            p2 = p2.next;
        }

        return true;


    }

    private static Node reverseList(Node slow) {
        Node prev = null;
        Node curr = slow;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }
}
