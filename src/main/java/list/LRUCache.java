package list;

import util.TwoWayListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU缓存
 */

public class LRUCache {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4
    }

    private int count;
    private int capacity;
    private TwoWayListNode head;
    private TwoWayListNode tail;
    private Map<Integer, TwoWayListNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new TwoWayListNode();
        this.tail = new TwoWayListNode();
        head.setNext(tail);
        tail.setPrev(head);
        map = new HashMap<>();
    }

    public int get(int key) {
        TwoWayListNode node = map.get(key);
        if (null == node) {
            return -1;
        }
        move2First(node);
        return node.getVal();
    }

    public void put(int key, int value) {
        TwoWayListNode node = map.get(key);
        if (null == node) {
            TwoWayListNode newNode = new TwoWayListNode(key, value);
            add2First(newNode);
            map.put(key, newNode);
            count++;
            if (count > capacity) {
                TwoWayListNode last = removeLast();
                map.remove(last.getKey());
            }
        } else {
            node.setVal(value);
            move2First(node);
        }
    }

    private void move2First(TwoWayListNode node) {
        removeNode(node);
        add2First(node);
    }

    private TwoWayListNode removeLast() {
        TwoWayListNode last = tail.getPrev();
        removeNode(last);
        return last;
    }

    private void removeNode(TwoWayListNode node) {
        TwoWayListNode prev = node.getPrev();
        TwoWayListNode next = node.getNext();
        prev.setNext(next);
        next.setPrev(prev);
    }

    private void add2First(TwoWayListNode node) {
        TwoWayListNode first = head.getNext();
        node.setPrev(head);
        head.setNext(node);
        node.setNext(first);
        first.setPrev(node);
    }
}