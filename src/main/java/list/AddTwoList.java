package list;

import util.GeneratorUtil;
import util.ListNode;
import util.PrinterUtil;

/**
 * 两个链表相加返回一个新链表
 */

public class AddTwoList {
    public static void main(String[] args) {
        ListNode node1 = GeneratorUtil.newSortedList(7);
        ListNode node2 = GeneratorUtil.newSortedList(9);
        ListNode node = addTwoList(node1, node2);
        PrinterUtil.printList(node1);
        PrinterUtil.printList(node2);
        PrinterUtil.printList(node);
    }

    private static ListNode addTwoList(ListNode node1, ListNode node2) {
        ListNode node = null;
        ListNode head = null;
        int carry = 0;
        while (node1 != null || node2 != null) {
            int x = node1 != null ? node1.getVal() : 0;
            int y = node2 != null ? node2.getVal() : 0;
            int remain = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;
            if (null == node) {
                node = new ListNode(remain);
                head = node;
            } else {
                node.setNext(new ListNode(remain));
                node = node.getNext();
            }
            if (node1 != null) {
                node1 = node1.getNext();
            }
            if (node2 != null) {
                node2 = node2.getNext();
            }
        }
        // 这个地方不能少
        if (carry > 0) {
            node.setNext(new ListNode(carry));
        }
        return head;
    }
}