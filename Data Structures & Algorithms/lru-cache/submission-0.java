class LRUCache {


    class CacheObj {

        CacheObj next = null;
        CacheObj prev = null;

        int key;
        int value;

        public CacheObj(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // most recent used go to head, least recent used go to tail;
    private CacheObj head = new CacheObj(-1, -1);
    private CacheObj tail = new CacheObj(-1, -1);
    private Map<Integer, CacheObj> cacheMap;
    private int capacity;

    public LRUCache(int capacity) {
        this.head.next = tail;
        this.tail.prev = head;
        this.cacheMap = new HashMap<>(capacity);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            CacheObj cache = cacheMap.get(key);
            moveToHead(key, cache);
            return cache.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {

        CacheObj newCache = new CacheObj(key, value);

        if (cacheMap.containsKey(key)) {
            moveToHead(key, newCache);
        } else {
            if (cacheMap.size() == capacity) {
                popLRU();
            }
            moveToHead(key, newCache);
        }
    }

    private void popLRU() {
        // find the cache from tail
        CacheObj cacheToRemove = tail.prev;
        // remove link
        cacheToRemove.prev.next = cacheToRemove.next;
        cacheToRemove.next.prev = cacheToRemove.prev;
        cacheToRemove.prev = null;
        cacheToRemove.next = null;

        // remove from map
        cacheMap.remove(cacheToRemove.key);
    }

    private void moveToHead(int key, CacheObj newCache) {
        // drop from map;
        CacheObj cacheToRemove = cacheMap.remove(key);
        // remove from list
        if (cacheToRemove != null) {
            cacheToRemove.prev.next = cacheToRemove.next;
            cacheToRemove.next.prev = cacheToRemove.prev;
            cacheToRemove.prev = null;
            cacheToRemove.next = null;
        }

        // add new Cache to map
        cacheMap.put(key, newCache);

        // add newCache to head
        newCache.prev = head;
        newCache.next = head.next;
        head.next.prev = newCache;
        head.next = newCache;
    }
}
