package list;

import util.ListNode;

/**
 * 找到循环链表第一个节点
 */

public class FindFirstCircleNode {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node3);
        System.out.println(find(node1).getVal());
    }

    private static ListNode find(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                // 从头开始
                fast = head;
                while (fast != slow) {
                    fast = fast.getNext();
                    slow = slow.getNext();
                }
                return slow;
            }
        }
        return null;
    }
}