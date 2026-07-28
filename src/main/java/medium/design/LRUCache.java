package medium.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    private class Node<K, V> {
        K key;
        V val;
        Node<K, V> next;
        Node<K, V> prev;

        Node(K key, V val) {
            this.key = key;
            this.val = val;

        }

    }

    int capacity;
    Map<K, Node<K, V>> cache;
    Node<K, V> head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;

    }

    public V get(K key) {
        V v = null;

        return v;
    }

    private void insertAtHead(Node<K, V> node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;


    }


}


