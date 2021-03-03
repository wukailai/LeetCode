package list;

import util.ListNode;

/**
 * 循环链表
 */

public class CycleList {
    public static void main(String[] args) {

    }

    /**
     * 判断是否有环
     */
    private static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断两个链表是否相交
     */
    private static boolean isIntersect(ListNode head1, ListNode head2) {
        while (head1 != null && head1.getNext() != null) {
            head1 = head1.getNext();
        }
        while (head2 != null && head2.getNext() != null) {
            head2 = head2.getNext();
        }
        return head1 == head2;
    }

    /**
     * 计算环长
     */
    private static int calCycleLength(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        int len = 0;
        while (count < 2 && fast != null && fast.getNext() != null) {
            if (count == 1) {
                len++;
            }
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                count++;
            }
        }
        return len;
    }
}