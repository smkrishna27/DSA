package roku;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheWithoutLinkedHashMap {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    Map<Integer, Node> cache;
    int capacity;
    Node head;
    Node tail;
    public LRUCacheWithoutLinkedHashMap(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0,0);

        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }


    public void addNode(Node node) {

       node.next = head.next;
       node.prev = head;
      head.next.prev = node;
      head.next = node;
    }

    public void removeNode(Node node) {
        if(node.prev!=null)
            node.prev.next = node.next;
        else
            head = node.next;
        if(node.next!=null)
            node.next.prev = node.prev;
        else
            tail = node.prev;
    }
    public void moveToHead(Node node) {
        if(node ==head) return;
        removeNode(node);
        addNode(node);
    }
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToHead(node);
        } else{
            Node node = new Node(key, value);
            //cache.put(key, node);
            if(cache.size()==capacity){
                Node last = tail.prev;
                cache.remove(last.key);
                removeNode(last);
            }
            addNode(node);
            cache.put(key, node);

        }

    }
    public void printAll() {
        for (Map.Entry<Integer, Node> entry : cache.entrySet()) {
            System.out.print(entry.getKey() + " ");
        }
    }
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            moveToHead(node);
            return node.value;
        }
        return -1;
    }


    public static void main(String[] args) {
        LRUCacheWithoutLinkedHashMap cache = new LRUCacheWithoutLinkedHashMap(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
       System.out.println(cache.get(1));
        cache.put(4, 4);
        cache.put(5, 5);
        cache.printAll();
        //System.out.println(cache.get(4));
       // System.out.println(cache.get(1));

    }




}
