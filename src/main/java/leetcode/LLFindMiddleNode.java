package leetcode;

public class LLFindMiddleNode {


    private Node head;
    private Node tail;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LLFindMiddleNode(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (head == null) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("\nLinked List:");
        if (head == null) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }


    public Node findMiddleNode(){
        int middle= nodeLength(head)/2;
        Node current = head;
        while(middle>0){
            current = current.next;
            middle--;
        }

        return current;
    }

    public Node findMiddleNodeNew(){

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
       return slow;


    }

    private int nodeLength(Node node){
        int len=0;
        while(node !=null){
            len++;
            node= node.next;
        }
        return len;
    }


    public static void main(String[] args) {
        LLFindMiddleNode llFindMiddleNode = new LLFindMiddleNode(8);
        llFindMiddleNode.append(1);

        llFindMiddleNode.append(4);
        llFindMiddleNode.append(5);
        llFindMiddleNode.append(6);
        llFindMiddleNode.append(7);
        System.out.println(llFindMiddleNode.findMiddleNode().value);
        System.out.println(llFindMiddleNode.findMiddleNodeNew().value);
    }

}

