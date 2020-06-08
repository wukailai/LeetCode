package list;

import sun.rmi.rmic.Generator;
import util.GeneratorUtil;
import util.ListNode;
import util.PrinterUtil;

/**
 * 反转链表
 */

public class ReverseList {
    public static void main(String[] args) {
        ListNode head = GeneratorUtil.newList();
        PrinterUtil.printList(head);
        ListNode newHead = reverse(head);
        PrinterUtil.printList(newHead);
        ListNode newHead2 = reverse2(newHead);
        PrinterUtil.printList(newHead2);
    }

    /**
     * 递归实现
     */
     private static ListNode reverse(ListNode head) {
         if (null == head || null == head.getNext()) {
             return head;
         }
         ListNode newHead = reverse(head.getNext());
         head.getNext().setNext(head);
         head.setNext(null);
         return newHead;
     }

    /**
     * 非递归实现
     */
    private static ListNode reverse2(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.getNext();
            head.setNext(pre);
            pre = head;
            head = next;
        }
        return pre;
    }
}