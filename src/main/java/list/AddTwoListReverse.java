package list;

import util.GeneratorUtil;
import util.ListNode;
import util.PrinterUtil;

import java.util.Stack;

/**
 * 反向相加两个链表   限制：不可反转链表
 * 思路：链表数据入栈 + 头插入法
 */

public class AddTwoListReverse {
    public static void main(String[] args) {
        ListNode head1 = GeneratorUtil.newList();
        ListNode head2 = GeneratorUtil.newList2();
        PrinterUtil.printList(head1);
        PrinterUtil.printList(head2);
        ListNode head = add(head1, head2);
        PrinterUtil.printList(head);
    }

    private static ListNode add(ListNode head1, ListNode head2) {
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();
        while (head1 != null) {
            stack1.push(head1.getVal());
            head1 = head1.getNext();
        }
        while (head2 != null) {
            stack2.push(head2.getVal());
            head2 = head2.getNext();
        }
        ListNode head = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int value1 = stack1.isEmpty() ? 0 : stack1.pop();
            int value2 = stack2.isEmpty() ? 0 : stack2.pop();
            int remain = (value1 + value2 + carry) % 10;
            carry = (value1 + value2 + carry) / 10;
            ListNode node = new ListNode(remain);
            node.setNext(head);
            head = node;
        }
        if (carry > 0) {
            ListNode node = new ListNode(carry);
            node.setNext(head);
            head = node;
        }
        return head;
    }
}