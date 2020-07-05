package list;

import util.GeneratorUtil;
import util.ListNode;
import util.PrinterUtil;

/**
 * 删除指定节点（节点存在且非首非尾）
 */

public class RemoveAppointNode {
    public static void main(String[] args) {
        ListNode head = GeneratorUtil.newList2();
        PrinterUtil.printList(head);
        ListNode newHead = remove(head, 1);
        PrinterUtil.printList(newHead);
    }

    private static ListNode remove (ListNode head, int target) {
       while (head.getVal() == target) {
           head = head.getNext();
       }
       ListNode node = head;
       ListNode next = node.getNext();
       while (node != null && next != null) {
           if (next.getVal() == target) {
               next = next.getNext();
               node.setNext(next);
           } else {
               node = next;
               next = next.getNext();
           }
       }
       return head;
    }
}