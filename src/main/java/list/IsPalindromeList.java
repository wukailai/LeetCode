package list;

import util.GeneratorUtil;
import util.ListNode;
import util.PrinterUtil;

/**
 * 是否为回文链表
 */

public class IsPalindromeList {
    public static void main(String[] args) {
        ListNode node = GeneratorUtil.newList2();
        System.out.println(isPalindrome(node));
    }

    private static boolean isPalindrome(ListNode head) {
        ListNode mid = findMid(head);
        PrinterUtil.printList(head);
        ListNode secondHead = reverseList(mid.getNext());
        mid.setNext(secondHead);
        PrinterUtil.printList(head);
        while (secondHead != null) {
            if (head.getVal() != secondHead.getVal()) {
                return false;
            }
            head = head.getNext();
            secondHead = secondHead.getNext();
        }
        return true;
    }

    private static ListNode reverseList(ListNode head) {
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