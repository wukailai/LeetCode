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
        return mergeTwoList(preHead, postHead);
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

    private static ListNode mergeTwoList(ListNode preHead, ListNode postHead) {
        ListNode head = null;
        ListNode tail = null;
        boolean flag = true;
        while (preHead != null || postHead != null) {
            if (null == head) {
                head = tail = preHead;
                preHead = preHead.getNext();
            } else {
                if (flag) {
                    tail.setNext(preHead);
                    preHead = preHead.getNext();
                } else {
                    tail.setNext(postHead);
                    postHead = postHead.getNext();
                }
                tail = tail.getNext();
            }
            flag = !flag;
        }
        return head;
    }

    private static ListNode mergeTwoList2(ListNode preHead, ListNode postHead) {
        ListNode head = null;
        ListNode node = null;
        boolean isFlag = true;
        while (postHead != null) {
            if (null == head) {
                head = preHead;
                node = head;
                preHead = preHead.getNext();
            } else {
                if (isFlag) {
                    node.setNext(preHead);
                    preHead = preHead.getNext();
                } else {
                    node.setNext(postHead);
                    postHead = postHead.getNext();
                }
                node = node.getNext();
            }
            isFlag = !isFlag;
        }
        if (preHead != null) {
            node.setNext(preHead);
        }
        return head;
    }
}