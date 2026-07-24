package capitalone;


import java.util.*;

public class LRUCacheOptimal {

    // LRUCache implemented as a static inner class
    static class LRUCache {
        private class Node {
            int key, value;
            Node prev, next;

            Node(int k, int v) {
                this.key = k;
                this.value = v;
            }
        }

        private int capacity;
        private Map<Integer, Node> cache;
        private Node head, tail;  // dummy head and tail

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>();
            // Initialize dummy head and tail
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        /**
         * Remove a node from the doubly linked list.
         */
        private void remove(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        /**
         * Insert a node right after the head (most recent position).
         */
        private void insertAtHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            // Move accessed node to head (most recent)
            Node node = cache.get(key);
            remove(node);
            insertAtHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                // Update existing node and move to head
                Node node = cache.get(key);
                node.value = value;
                remove(node);
                insertAtHead(node);
            } else {
                // Create new node
                Node node = new Node(key, value);
                cache.put(key, node);
                insertAtHead(node);
                if (cache.size() > capacity) {
                    // Evict least recently used node (tail.prev)
                    Node lru = tail.prev;
                    remove(lru);
                    cache.remove(lru.key);
                }
            }
        }
    }

    // Main method for testing the LRUCache functionality
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("get(1): " + cache.get(1));  // Expected output: 1
        cache.put(3, 3);  // Evicts key 2
        System.out.println("get(2): " + cache.get(2));  // Expected output: -1
        cache.put(4, 4);  // Evicts key 1
        System.out.println("get(1): " + cache.get(1));  // Expected output: -1
        System.out.println("get(3): " + cache.get(3));  // Expected output: 3
        System.out.println("get(4): " + cache.get(4));  // Expected output: 4
    }
}
