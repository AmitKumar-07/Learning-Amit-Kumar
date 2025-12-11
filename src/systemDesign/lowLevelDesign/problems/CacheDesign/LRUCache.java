package systemDesign.lowLevelDesign.problems.CacheDesign;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node {
        int key, value;
        Node next, prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DLL {
        Node head, tail;
        int size;

        DLL() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public Node removeLast() {
            if (size == 0) return null;
            Node node = tail.prev;
            remove(node);
            return node;
        }
    }

    public Map<Integer, Node> mp;
    int capacity;
    DLL dll;

    public LRUCache(int capacity) {
        this.mp = new HashMap<>();
        this.capacity = capacity;
        this.dll = new DLL();
    }

    public int get(int key) {

        if (!mp.containsKey(key)) {
            return -1;
        }

        Node node = mp.get(key);
        dll.remove(node);
        dll.addToHead(node);
        return node.value;
    }

    public void put(int key, int value) {

        if (mp.containsKey(key)) {
            Node node = mp.get(key);
            node.value = value;
            dll.remove(node);
            dll.addToHead(node);
        } else {
            if (mp.size() == capacity) {
                Node node = dll.removeLast();
                mp.remove(node.key);
            }

            Node node = new Node(key, value);
            mp.put(key, node);
            dll.addToHead(node);
        }
    }
}
