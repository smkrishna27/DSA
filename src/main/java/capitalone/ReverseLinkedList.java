package capitalone;

public class ReverseLinkedList {


    Node head;
    Node tail;
    int length;


    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            length++;
        } else {
            tail.next = newNode;
            tail = newNode;
            length++;

        }
    }

    public int length() {
        return length;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " " + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after, before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next; //save next node
            temp.next = before; // reverse the link
            before = temp; //move before forward
            temp = after; // move temp forward

        }

    }

    public void reverseAlternative() {
       Node before= null;
       Node current= head;
       Node after;
       while (current!=null){
           after = current.next; //save next
           current.next = before; //Reverse link
           before = current; //move before forward
           current = after; // move current forward
       }
        head = before;
    }

    public Node reverseRecursive(Node current,Node before) {
        if (current == null) return before;
        Node after = current.next;
        current.next = before;
        return reverseRecursive(after, current);
    }
 public void reverseRecursive() {
        tail = head;
        head = reverseRecursive(head, null);
    }



    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.push(1);
        list.push(2);
        list.push(3);
        list.print();
        list.push(4);
        list.print();
        list.reverse();
        list.print();
        list.reverseAlternative();
        list.print();
        list.reverseRecursive();
        list.print();
    }
}
