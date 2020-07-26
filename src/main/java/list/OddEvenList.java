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
        sort(head);
        PrinterUtil.printList(head);
    }

    private static void sort(ListNode head) {
        if (null == head || null == head.getNext()) {
            return;
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
    }
}