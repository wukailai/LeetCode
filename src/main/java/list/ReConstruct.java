package list;

import util.GeneratorUtil;
import util.ListNode;
import util.PrinterUtil;

/**
 * 重建链表
 */

public class ReConstruct {
    public static void main(String[] args) {
        ListNode head = GeneratorUtil.newList();
        PrinterUtil.printList(head);
        ListNode newHead = reConstruct(head);
        PrinterUtil.printList(newHead);
    }

    private static ListNode reConstruct(ListNode preHead) {
        ListNode mid = findMid(preHead);
        ListNode postHead = reverse(mid.getNext());
        mid.setNext(null);
        ListNode head = null;
        ListNode tail = null;
        boolean flag = true;
        while (postHead != null) {
            if (null == head) {
                head = tail = preHead;
                preHead = preHead.getNext();
            } else {
                ListNode next;
                if (flag) {
                    next = preHead;
                    preHead = preHead.getNext();
                } else {
                    next = postHead;
                    postHead = postHead.getNext();
                }
                tail.setNext(next);
                tail = tail.getNext();
            }
            flag = !flag;
        }
        if (preHead != null) {
            tail.setNext(preHead);
        }
        return head;
    }

    private static ListNode reverse(ListNode head) {
        ListNode node = head;
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.getNext();
            node.setNext(pre);
            pre = node;
            node = next;
        }
        return pre;
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
}