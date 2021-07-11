package list;

import util.GeneratorUtil;
import util.ListNode;
import util.PrinterUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 每K个节点反转
 */

public class ReverseListByK {
    public static void main(String[] args) {
        ListNode head = GeneratorUtil.newList();
        int k = 2;
        ListNode newHead = reverse(head, k);
        PrinterUtil.printList(newHead);
    }

    private static ListNode reverse(ListNode head , int k) {
        if (null == head || null == head.getNext()) {
            return head;
        }
        List<ListNode> headList = gatherHeadList(head, k);
        ListNode newHead = reverseByK(head, k);
        ListNode result = newHead;
        ListNode newTail = head;
        for (int i = 1; i < headList.size(); i++) {
            ListNode node = headList.get(i);
            newHead = reverseByK(node, k);
            newTail.setNext(newHead);
            newTail = node;
        }
        return result;
    }

    /**
     * 收集头节点
     */
    private static List<ListNode> gatherHeadList(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        list.add(node);
        int count = 0;
        while (node != null) {
            node = node.getNext();
            count++;
            if (count == k) {
                count = 0;
                list.add(node);
            }
        }
        return list;
    }

    /**
     * 每k个节点反转
     */
    private static ListNode reverseByK(ListNode head, int k) {
        ListNode pre = null;
        ListNode next;
        while (k > 0 && head != null) {
            next = head.getNext();
            head.setNext(pre);
            pre = head;
            head = next;
            k--;
        }
        return pre;
    }
}