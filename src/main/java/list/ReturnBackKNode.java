package list;

import util.GeneratorUtil;
import util.ListNode;
import util.PrinterUtil;

/**
 * 返回链表倒数第K个节点
 */

public class ReturnBackKNode {
    public static void main(String[] args) {
        ListNode head = GeneratorUtil.newList();
        PrinterUtil.printList(head);
        System.out.println(getBackK(head, 2).getVal());
    }

    private static ListNode getBackK(ListNode head, int k) {
        ListNode start = head;
        ListNode end = head;
        for (int i = 0; i < k; i++) {
            end = end.getNext();
        }
        while (end != null) {
            start = start.getNext();
            end = end.getNext();
        }
        return start;
    }
}