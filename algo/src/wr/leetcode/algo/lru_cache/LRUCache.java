package wr.leetcode.algo.lru_cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    final Map<Integer, CacheValue> map;
    final int capacity;
    final DoubleListNode helper;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.helper = new DoubleListNode(-1);
    }

    public int get(int key) {
        int ret = -1;
        CacheValue cacheValue = map.get(key);
        if(null != cacheValue) {
            ret = cacheValue.value;
            DoubleListNode node = cacheValue.node;
            //remove from list
            node.removeFromList();
            //put to helper.next
            addToHead(node);
        }
        return ret;
    }

    public void set(int key, int value) {

        CacheValue cacheValue = map.getOrDefault(key, new CacheValue(key, value));
        //set value
        cacheValue.value = value;
        //remove from list
        DoubleListNode node = cacheValue.node;
        node.removeFromList();
        //put to helper.next
        addToHead(node);
        map.put(key, cacheValue);

        if(map.size() > capacity) {
            DoubleListNode delete = helper.prev;
            delete.removeFromList();
            int deletekey = delete.key;
            map.remove(deletekey);
        }
    }

    private void addToHead(DoubleListNode node ) {
        DoubleListNode helperNext = helper.next;
        helperNext.prev = node;
        node.next = helperNext;
        helper.next = node;
        node.prev = helper;
    }

}

class CacheValue{
    Integer value;
    DoubleListNode node;// should put key

    public CacheValue(int key, int value ) {
        this.node = new DoubleListNode(key);
        this.value = value;
    }
}

class DoubleListNode {
    DoubleListNode prev;
    DoubleListNode next;
    int key;

    public DoubleListNode(int key) {
        this.key = key;
        this.prev = this;
        this.next = this;
    }

    public void removeFromList() {
        DoubleListNode prev = this.prev;
        DoubleListNode next = this.next;
        next.prev = prev;
        prev.next = next;
        this.prev = this;
        this.next = this;
    }
}