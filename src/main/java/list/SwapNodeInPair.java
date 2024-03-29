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

    /**
     * 更容易理解的一种方式
     * 投机取巧的做法，不建议
     */
    private static ListNode swap2(ListNode head) {
        if (null == head || null == head.getNext()) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.getNext();
        while (first != null && second != null) {
            int temp = first.getVal();
            first.setVal(second.getVal());
            second.setVal(temp);
            first = second.getNext();
            second = first.getNext();
        }
        return head;
    }
}