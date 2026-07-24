package datastructures.linkedlist;

public class NewLinkedList {

    private Node head;
    private Node tail;
    private int length;
    public NewLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }


    public NewLinkedList(int val) {
        Node node = new Node(val);
        head =  node;
        tail = node;
        length = 1;
    }

    public void append(int val){
        Node node = new Node(val);
        if(length == 0){
            head = node;
            tail = node;
            length = 1;
        }
        else{
            tail.next = node;
            tail = node;
            length++;
        }
    }

    public void prepend(int val){
        Node node = new Node(val);
        if(length == 0){
            head = node;
            tail = node;
            length = 1;
        }
        else{
            node.next = head;
            head = node;
            length++;

        }
    }

    public boolean insert(int index,int val){

        if(index < 0 ){ return false; }

        if (index == 0){
            prepend(val);
            return true;
        }
        if (index == length){
            append(val);
            return true;
        }
       Node node = new Node(val);
        int currentNode = index>length? length-1: index-1;
        Node temp = getNode(currentNode);
        node.next = temp.next;
        temp.next = node;
        length++;
        return true;
    }


    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value +" ");
            current = current.next;
        }
    }

    public  void getHead(){
        System.out.println("Head: "+head.value);
    }

    public  void getTail(){
        System.out.println("Tail: "+tail.value);
    }

    public void getLength(){
        System.out.println("Length: "+length);
    }

    public Node getNode(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;

    }

    public boolean set(int index,int val){
        if (index < 0 || index >= length) return false;
        Node node = getNode(index);
        if (node == null) return false;
        node.value = val;
        return true;
    }

    public Node remove(int index){
        if (index < 0 || index >= length) return null;
        if (index == 0){
           return removeFirst();

        }
        if (index == length-1){
           return removeLast();
        }
        Node prev = getNode(index-1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public Node removeLast(){
        if (length == 0) return null;
        Node temp = head;
        Node pre = head;
        while (temp.next != null){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if(length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }

    public Node removeFirst(){
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if(length == 0){
            tail = null;
        }
        return temp;
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node after ;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }


    public void swapPairs(){
        Node temp = head;

        while (temp!=null && temp.next != null){
            int tmp = temp.value;
            temp.value = temp.next.value;
            temp.next.value = tmp;
            temp = temp.next.next;

        }


    }
    public Node findMiddleNode(){
        int  length = getNodeLength(head);
        int middle = length/2;

        while(middle > 0){
            head = head.next;
            middle--;
        }
         return head;

    }

    private int getNodeLength(Node node){
        int length = 0;
        while (node != null){
            length++;
            node = node.next;
        }
        return length;
    }

    public boolean hasLoop(){
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public Node findKthFromEnd(int k){
        int length = getNodeLength(head);
        if(length == 0 || length<k) return null;

        for(int i = length-k; i > 0; i--){
            head = head.next;
        }
        return head;

    }

    public Node findKthFromEndAnother(int k) {
        if (k <= 0) return null;

        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) return null;
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public Node removeNthFrom( int k) {
        if(k <= 0 || head ==null) return head;
        Node current = head;
        int len =0 ;
        while(current  != null){
            len++;
            current = current.next;
        }
        if(len == k){
          Node temp = head.next;
          head.next = null;
         return temp;
        }

        Node pre = null;
        current = head;
      for(int i = 0; i <len - k ; i++){
          pre = current;
          current = current.next;
      }
      pre.next = current.next;
      current.next = null;
      return current;

    }

    public Node removeDuplicates(){
        Node current = head;
        while(current != null){
            Node next = current;
            while(next.next != null){
                if(current.value==next.next.value){
                    next.next = next.next.next;
                } else{
                    next = next.next;
                }
            }
            current = current.next;
        }

        return head;
    }


    public int binaryToDecimal() {
        int num = 0;
        Node current = head;
        while (current != null) {
            num = num * 2 + current.value;
            current = current.next;
        }
        return num;
    }

    public void partitionList(int x){
        Node less = new Node(0);
        Node more = new Node(0);
        Node prev1 = less;
        Node prev2 = more;
        Node current = head;
        while(current!= null){
            if(current.value<=x){
                prev1.next = current;
                prev1 = current;
            } else if(current.value> x){
                prev2.next = current;
                prev2 = more.next;

            }
            current = current.next;
        }
        prev2.next = null;
        prev1.next = more.next;
        head = less.next;


    }


    public void reverseBetween(int startIndex, int endIndex) {
        if (head == null) return;

        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;

        for (int i = 0; i < startIndex; i++) {
            previousNode = previousNode.next;
        }

        Node currentNode = previousNode.next;

        for (int i = 0; i < endIndex - startIndex; i++) {
            Node nodeToMove = currentNode.next;
            currentNode.next = nodeToMove.next;
            nodeToMove.next = previousNode.next;
            previousNode.next = nodeToMove;
        }

        head = dummyNode.next;
    }

    public static void main(String[] args) {

        NewLinkedList myLinkedList = new NewLinkedList(5);
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);

        //System.out.println( myLinkedList.removeNthFrom(3).value);
     //  myLinkedList.removeDuplicates();
        myLinkedList.printList();
       // myLinkedList.partitionList(3);
        System.out.println("after remove");
        myLinkedList.printList();
        System.out.println();
        myLinkedList.swapPairs();
        myLinkedList.printList();
        myLinkedList.reverseBetween(1,3);
        myLinkedList.printList();
        System.out.println();
        NewLinkedList list = new NewLinkedList(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.prepend(6);

        System.out.println(list.findKthFromEnd(1).value);
        System.out.println(list.findKthFromEndAnother(1).value);
        System.out.println(list.removeNthFrom(1));
        list.printList();
        System.out.println();
        System.out.println(list.hasLoop());
        list.printList();
        list.prepend(5);
        list.printList();
        System.out.println();
        list.insert(2,10);
        list.insert(2,12);
        list.insert(2,16);
        list.insert(2,19);
        list.printList();
        System.out.println();
       // list.reverse();
        System.out.println();
        list.printList();
        System.out.println();
        System.out.println("middle" +list.findMiddleNode().value);

        list.set(2, 25);
        System.out.println();
        list.printList();

        list.printList();
        list.removeLast();
        list.removeLast();
        System.out.println();
        System.out.println(list.removeFirst());
       // System.out.println(list.getNode(0).value);
       // list.remove(0);

        System.out.println();
        list.printList();

    }

    class Node {
        int value;

        Node next;
        Node(int value) {
            this.value = value;
        }
    }
}
