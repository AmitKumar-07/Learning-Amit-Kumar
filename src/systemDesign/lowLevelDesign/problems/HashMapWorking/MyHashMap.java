package systemDesign.lowLevelDesign.problems.HashMapWorking;

public class MyHashMap<K,V> {

    private static final int size = 1<<4; //16
    Entry[] hashTable;
    MyHashMap(){
        hashTable= new Entry[size];
    }

    static class Entry<K,V>{

        K key;
        V value;
        Entry next;
        Entry(K k, V v) {
            key = k;
            value = v;
        }

        public K getKey() {
            return key;
        }
        public void setKey(K key) {
            this.key = key;
        }
        public V getValue() {
            return value;
        }
        public void setValue(V value) {
            this.value = value;
        }
    }

    public void put(K key, V value) {

        int hashCode =(size - 1) & (key.hashCode() ^ key.hashCode() >>> 16);
        Entry node = hashTable[hashCode];
        if(node == null) {
            Entry newNode = new Entry(key, value);
            hashTable[hashCode] = newNode;
        } else {
            Entry previousNode = node;
            while (node != null) {
                if (node.key.equals(key)) {
                    node.value = value;
                    return;
                }
                previousNode = node;
                node = node.next;
            }
            previousNode.next = new Entry(key, value);
        }
    }

    public V get(K key) {

        int hashCode = (size - 1) & (key.hashCode() ^ key.hashCode() >>> 16);
        Entry node = hashTable[hashCode];
        while(node != null) {
            if(node.key.equals(key)) {
                return (V)node.value;
            }
            node = node.next;
        }
        return null;
    }

    public static void main(String[] args) {

        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(1, "hi");
        map.put(2, "my");
        map.put(3, "name");
        map.put(4, "is");
        map.put(5, "Shreyansh");
        map.put(6, "how");
        map.put(7, "are");
        map.put(8, "you");
        map.put(9, "friends");
        map.put(10, "?");

        String value = map.get(8);
        System.out.println(value);
    }
}
