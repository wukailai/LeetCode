package list;

import util.GeneratorUtil;
import util.ListNode;
import util.PrinterUtil;

/**
 * 删除连续的节点
 */

public class RemoveDuplicateNodeInRow {
    public static void main(String[] args) {
        ListNode head = GeneratorUtil.newList6();
        ListNode newHead = remove(head);
        if (null == newHead) {
            System.out.println("newHead is null");
        } else {
            PrinterUtil.printList(newHead);
        }
    }

    private static ListNode remove(ListNode head) {
        if (null == head || null == head.getNext()) {
            return head;
        }
        ListNode newHead;
        // 头节点处理
        ListNode node = head;
        ListNode next = node.getNext();
        while (next != null && node.getVal() == next.getVal()) {
            while (next != null && node.getVal() == next.getVal()) {
                next = next.getNext();
            }
            if (null == next) {
                return null;
            }
            node = next;
            next = next.getNext();
        }
        newHead = node;
        // 处理重复节点
        while (next != null && next.getNext() != null) {
            ListNode last = next.getNext();
            if (next.getVal() == last.getVal()) {
                while (last != null && last.getVal() == next.getVal()) {
                    last = last.getNext();
                }
                node.setNext(last);
            }
            node = next;
            next = last;
        }
        return newHead;
    }
}