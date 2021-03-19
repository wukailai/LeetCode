package list;

import util.GeneratorUtil;
import util.ListNode;
import util.PrinterUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 合并k个有序链表
 */

public class MergeKSortedList {
    public static void main(String[] args) {
        List<ListNode> list = new ArrayList();
        ListNode head1 = GeneratorUtil.newList();
        ListNode head2 = GeneratorUtil.newList3();
        ListNode head3 = GeneratorUtil.newList4();
        PrinterUtil.printList(head1);
        PrinterUtil.printList(head2);
        PrinterUtil.printList(head3);
        list.add(head1);
        list.add(head2);
        list.add(head3);
        ListNode head = merge(list);
        PrinterUtil.printList(head);
    }

    private static ListNode merge(List<ListNode> list) {
        if (null == list || list.size() == 0) {
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        if (list.size() == 2) {
            return mergeTwoList(list.get(0), list.get(1));
        }
        int mid = (list.size() - 1) / 2;
        List<ListNode> preList = new ArrayList();
        for (int i = 0; i <= mid; i++) {
            preList.add(list.get(i));
        }
        List<ListNode> postList = new ArrayList();
        for (int i = mid + 1; i < list.size(); i++) {
            postList.add(list.get(i));
        }
        return mergeTwoList(merge(preList), merge(postList));
    }

    private static ListNode mergeTwoList(ListNode head1, ListNode head2) {
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
                    head = head1;
                    tail = head1;
                } else {
                    tail.setNext(head1);
                    tail = head1;
                }
                head1 = head1.getNext();
            } else {
                if (null == head) {
                    head = head2;
                    tail = head2;
                } else {
                    tail.setNext(head2);
                    tail = head2;
                }
                head2 = head2.getNext();
            }
        }
        return head;
    }
}