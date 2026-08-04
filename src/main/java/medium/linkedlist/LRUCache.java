package medium.linkedlist;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListSet;

public class LRUCache {


    class Node {

        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;


    LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            addNodeAtHead(node);
            return node.val;
        }


        return -1;
    }

    public void put(int key, int val) {

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = val;
            removeNode(node);
            addNodeAtHead(node);
        } else {
            if (map.size() >= capacity) {
                Node last = tail.prev;
                removeNode(last);
                map.remove(last.key);
            }
            Node node = new Node(key, val);
            addNodeAtHead(node);
            map.put(key, node);
        }


    }


    private void addNodeAtHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;


    }

    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;


    }

    public void printAll() {
        Node temp = head.next;
        while (temp != tail) {
            System.out.println(temp.key + " " + temp.val);
            temp = temp.next;
        }
    }


    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.printAll();
        lruCache.get(1);
        lruCache.put(4, 4);
        lruCache.printAll();


    }

}
