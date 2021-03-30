package list;

import util.GeneratorUtil;
import util.ListNode;
import util.PrinterUtil;

/**
 * 链表排序
 * 使用归并排序
 */

public class SortList {
    public static void main(String[] args) {
        ListNode head = GeneratorUtil.newList5();
        PrinterUtil.printList(head);
        ListNode newHead = sort(head);
        PrinterUtil.printList(newHead);
    }

    private static ListNode sort(ListNode head) {
        if (null == head || null == head.getNext()) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode newHead = mid.getNext();
        mid.setNext(null);
        return merge(sort(head), sort(newHead));
    }

    private static ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    private static ListNode merge(ListNode head1, ListNode head2) {
        if (null == head1) {
            return head2;
        }
        if (null == head2) {
            return head1;
        }
        ListNode head = null;
        ListNode tail = null;
        while (head1 != null || head2 != null) {
            int val1 = head1 != null ? head1.getVal() : Integer.MAX_VALUE;
            int val2 = head2 != null ? head2.getVal() : Integer.MAX_VALUE;
            if (val1 <= val2) {
                if (null == head) {
                    head = tail = new ListNode(val1);
                } else {
                    tail.setNext(new ListNode(val1));
                    tail = tail.getNext();
                }
                head1 = head1.getNext();
            } else {
                if (null == head) {
                    head = tail = new ListNode(val2);
                } else {
                    tail.setNext(new ListNode(val2));
                    tail = tail.getNext();
                }
                head2 = head2.getNext();
            }
        }
        return head;
    }
}