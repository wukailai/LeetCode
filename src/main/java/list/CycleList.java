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
     * 计算环长
     */
    private static int calCycleLength(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        int len = 0;
        while (count < 2 && fast != null && fast.getNext() != null) {
            if (count > 0) {
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