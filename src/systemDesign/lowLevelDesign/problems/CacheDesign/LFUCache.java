package systemDesign.lowLevelDesign.problems.CacheDesign;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    class Node{
        int key, value, freq;
        Node next, prev;
        Node(int key, int vale){
            this.key = key;
            this.value = vale;
            this.freq = 1;
        }
    }

    class DLL{

        Node head, tail;
        int size;
        DLL(){
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void insertToHead(Node node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast(){
            if(size > 0){
                Node prev = tail.prev;
                remove(prev);
                return prev;
            }
            return null;
        }
    }

    public int minFreq, capacity;
    public Map<Integer, Node> keyNodeMap;
    public Map<Integer, DLL> freqListMap; //<freq, list of node>

    public LFUCache(int capacity){
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyNodeMap = new HashMap<>();
        this.freqListMap = new HashMap<>();
    }

    public int get(int key){

        if(!keyNodeMap.containsKey(key)){
            return -1;
        }

        Node node = keyNodeMap.get(key);
        updateFreq(node);
        return node.value;
    }

    public void put(int key, int value){

        if(keyNodeMap.containsKey(key)){
            Node node = keyNodeMap.get(key);
            node.value = value;
            updateFreq(node);
            return;
        }
        if(keyNodeMap.size() == capacity){
            Node node = freqListMap.get(minFreq).removeLast();
            keyNodeMap.remove(node.key);
        }

        Node node = new Node(key, value);
        minFreq = 1;
        keyNodeMap.put(key, node);
        freqListMap.putIfAbsent(minFreq, new DLL());
        freqListMap.get(minFreq).insertToHead(node);
    }

    public void updateFreq(Node node){
        int oldFreq = node.freq;
        freqListMap.get(oldFreq).remove(node);
        if(freqListMap.get(oldFreq).size==0 && minFreq == oldFreq){
            minFreq++;
        }
        node.freq++;
        freqListMap.putIfAbsent(node.freq, new DLL());
        freqListMap.get(node.freq).insertToHead(node);
    }
}
