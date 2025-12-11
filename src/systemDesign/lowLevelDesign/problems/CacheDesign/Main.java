package systemDesign.lowLevelDesign.problems.CacheDesign;

public class Main {

    public static void main(String[] args) {

        System.out.println("LRU Cache");
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,4);
        lruCache.put(3,6);
        lruCache.get(2);
        lruCache.put(5,6);
        lruCache.put(7,8);
        lruCache.mp.entrySet().stream().forEach(mp-> System.out.println(mp.getKey()+":"+mp.getValue().value));

        System.out.println("\nLFU Cache");
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(2, 10);
        lfuCache.put(3, 20);
        lfuCache.get(2);
        lfuCache.put(4,30);
        lfuCache.keyNodeMap.entrySet().stream().forEach(mp -> System.out.println(mp.getKey()+":"+mp.getValue().value));
    }
}
