package util;

/**
 * 链表节点
 */

public class TwoWayListNode {
    private int key;
    private int val;
    private TwoWayListNode prev;
    private TwoWayListNode next;

    public TwoWayListNode() {
    }

    public TwoWayListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

    public int getKey() {
        return key;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TwoWayListNode getPrev() {
        return prev;
    }

    public void setPrev(TwoWayListNode prev) {
        this.prev = prev;
    }

    public TwoWayListNode getNext() {
        return next;
    }

    public void setNext(TwoWayListNode next) {
        this.next = next;
    }
}