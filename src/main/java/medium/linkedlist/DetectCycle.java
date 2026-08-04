package medium.linkedlist;

public class DetectCycle {



    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;

        }

        return false;


    }

    public static void main(String[] args) {

        DetectCycle detectCycle = new DetectCycle();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = listNode.next;
        System.out.println(detectCycle.hasCycle(listNode));


    }
}
