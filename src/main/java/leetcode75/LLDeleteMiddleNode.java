package leetcode75;

public class LLDeleteMiddleNode {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = slow.next;

        return  head;
    }
//    Input: head = [1,2,3,4,5]
//    Output: [1,3,5,2,4]
public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head, even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;

        }
        odd.next = evenHead;

    return head;


}

    public int pairSum(ListNode head) {

        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            ListNode temp=slow.next;
            slow.next=prev;
            prev=slow;
            slow=temp;
        }
        int res=0;
        while(slow!=null){
            res=Math.max(res,(prev.val+slow.val));
            prev=prev.next;
            slow=slow.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode  head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(6);
        LLDeleteMiddleNode deleteMiddleNode = new LLDeleteMiddleNode();
        System.out.println(deleteMiddleNode.deleteMiddle(head));
        System.out.println(deleteMiddleNode.pairSum(head));
    }

}
