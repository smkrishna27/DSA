package medium.linkedlist;

import org.checkerframework.checker.units.qual.N;

public class ReverseLinkedList {

    static class Node {

        int val;
        Node next;

        Node(int val) {

            this.val = val;
        }
    }

    public Node reverseLinkedList(Node head) {

        Node previous = null;

        while (head != null) {
            Node next = head.next;
            head.next = previous;
            previous = head;
            head = next;


        }


        return previous;

    }

    public void printAll(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.val + "  -->");
            temp = temp.next;
        }
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.printAll(node);
        System.out.println();
        reverseLinkedList.printAll(reverseLinkedList.reverseLinkedList(node));


    }
}
