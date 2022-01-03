package list;

import util.GeneratorUtil;
import util.ListNode;
import util.PrinterUtil;

/**
 * 合并两个有序链表
 */

public class MergeTwoSortedList {
    public static void main(String[] args) {
        ListNode node1 = GeneratorUtil.newSortedList(3);
        ListNode node2 = GeneratorUtil.newSortedList(4);
        PrinterUtil.printList(node1);
        PrinterUtil.printList(node2);
        ListNode node = merge(node1, node2);
        PrinterUtil.printList(node);
    }

    private static ListNode merge(ListNode node1, ListNode node2) {
        if (null == node1) {
            return node2;
        }
        if (null == node2) {
            return node1;
        }
        ListNode newHead = null;
        ListNode node = null;
        while (node1 != null || node2 != null) {
            int val1 = node1 != null ? node1.getVal() : Integer.MAX_VALUE;
            int val2 = node2 != null ? node2.getVal() : Integer.MAX_VALUE;
            int val;
            if (val1 <= val2) {
                val = val1;
                node1 = node1.getNext();
            } else {
                val = val2;
                node2 = node2.getNext();
            }
            if (null == newHead) {
                newHead = new ListNode(val);
                node = newHead;
            } else {
                node.setNext(new ListNode(val));
                node = node.getNext();
            }
        }
        return newHead;
    }
}