package list;

import util.GeneratorUtil;
import util.ListNode;
import util.PrinterUtil;

/**
 * 成对交换链表中的节点
 */

public class SwapNodeInPair {
    public static void main(String[] args) {
        ListNode head = GeneratorUtil.newSortedList(9);
        PrinterUtil.printList(head);
        ListNode newHead = swap(head);
        PrinterUtil.printList(newHead);
    }

    /**
     * 递归
     */
    private static ListNode swap(ListNode head) {
        if (null == head) {
            return null;
        }
        if (null == head.getNext()) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.getNext();
        first.setNext(swap(second.getNext()));
        second.setNext(first);
        return second;
    }
}