package list;

import util.ListNode;

/**
 * 找出两个链表相交的第一个节点
 */

public class FindIntersectNode {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.setNext(node3);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        System.out.println(getIntersectNode(node1, node2));
        System.out.println(getIntersectNode2(node1, node2));
    }

    /**
     * 保证一定相交才可以调用，否则会出现死循环
     */
    private static ListNode getIntersectNode(ListNode head1, ListNode head2) {
        ListNode t1 = head1;
        ListNode t2 = head2;
        while (t1 != t2) {
            t1 = t1.getNext() != null ? t1.getNext() : head2;
            t2 = t2.getNext() != null ? t2.getNext() : head1;
        }
        return t1;
    }

    /**
     * 更通用的情况，没有相交返回null
     */
    private static ListNode getIntersectNode2(ListNode head1, ListNode head2) {
        int len1 = getLength(head1);
        int len2 = getLength(head2);
        if (len1 > len2) {
            return find(head1, head2, len1 - len2);
        } else {
            return find(head2, head1, len2 - len1);
        }
    }

    private static int getLength(ListNode head) {
        ListNode t = head;
        int count = 0;
        while (t != null) {
            t = t.getNext();
            count++;
        }
        return count;
    }

    private static ListNode find(ListNode longer, ListNode shorter, int gap) {
        for (int i = 0; i < gap; i++) {
            longer = longer.getNext();
        }
        while (longer != null && shorter != null) {
            shorter = shorter.getNext();
            longer = longer.getNext();
            if (shorter == longer) {
                return shorter;
            }
        }
        return null;
    }
}