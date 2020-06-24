package list;

import util.ListNode;

/**
 * 找出两个链表相交的第一个节点
 */

public class FindIntersectNode {
    public static void main(String[] args) {

    }

    private static ListNode getIntersectNode(ListNode head1, ListNode head2) {
        ListNode t1 = head1;
        ListNode t2 = head2;
        while (t1 != t2) {
            t1 = t1.getNext() != null ? t1.getNext() : head2;
            t2 = t2.getNext() != null ? t2.getNext() : head1;
        }
        return t1;
    }
}