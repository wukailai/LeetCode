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
        ListNode head = null;
        ListNode last = null;
        ListNode temp;
        while (node1 != null || node2 != null) {
            if (null == node1) {
                temp = node2;
            } else if (null == node2) {
                temp = node1;
            } else if (node1.getVal() <= node2.getVal()) {
                temp = node1;
            } else {
                temp = node2;
            }
            if (null == head) {
                head = temp;
                last = head;
            } else {
                last.setNext(temp);
                last = temp;
            }
            if (temp == node1) {
                node1 = node1.getNext();
            } else {
                node2 = node2.getNext();
            }
        }
        return head;
    }
}