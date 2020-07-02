package list;

import util.GeneratorUtil;
import util.ListNode;
import util.PrinterUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * 删除链表重复的节点
 */

public class RemoveDuplicateNode {
    public static void main(String[] args) {
        ListNode head = GeneratorUtil.newList2();
        PrinterUtil.printList(head);
        head = removeDuplicate2(head, new HashSet());
        // head = removeDuplicate(head);
        PrinterUtil.printList(head);
    }

    /**
     * 非递归实现
     */
    private static ListNode removeDuplicate(ListNode head) {
        if (null == head) {
            return null;
        }
        Set<Integer> set = new HashSet();
        set.add(head.getVal());
        ListNode node = head;
        ListNode next = head.getNext();
        while (next != null) {
            if (set.contains(next.getVal())) {
                next = next.getNext();
                node.setNext(next);
            } else {
                set.add(next.getVal());
                node = next;
                next = next.getNext();
            }
        }
        return head;
    }

    /**
     * 递归实现
     */
    private static ListNode removeDuplicate2(ListNode head, Set<Integer> set) {
        if (null == head) {
            return null;
        }
        if (!set.contains(head.getVal())) {
            set.add(head.getVal());
            head.setNext(removeDuplicate2(head.getNext(), set));
            return head;
        } else {
            return removeDuplicate2(head.getNext(), set);
        }
    }
}