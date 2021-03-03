package list;

import util.GeneratorUtil;
import util.ListNode;
import util.PrinterUtil;

/**
 * 基数偶数链表
 */

public class OddEvenList {
    public static void main(String[] args) {
        ListNode head = GeneratorUtil.newList();
        PrinterUtil.printList(head);
        PrinterUtil.printList(sort(head));
    }

    private static ListNode sort(ListNode head) {
        if (null == head || null == head.getNext()) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.getNext();
        ListNode evenHead = head.getNext();
        while (even != null && even.getNext() != null) {
            odd.setNext(even.getNext());
            odd = odd.getNext();
            even.setNext(odd.getNext());
            even = even.getNext();
        }
        odd.setNext(evenHead);
        return head;
    }
}