package util;

/**
 * 生成工具类
 */

public class GeneratorUtil {
    /**
     * 新建一个数组
     */
    public static int[] newIntArray() {
        return new int[] {1, 3, 6, 4, 5, 2};
    }

    /**
     * 新建一个有序数组
     */
    public static int[] newSortedIntArray() {
        return new int[] {1, 2, 3, 4, 5, 6};
    }

    /**
     * 创建一个链表
     */
    public static ListNode newList() {
        ListNode head = new ListNode(1);
        head.setNext(new ListNode(2));
        head.getNext().setNext(new ListNode(3));
        head.getNext().getNext().setNext(new ListNode(4));
        head.getNext().getNext().getNext().setNext(new ListNode(5));
        return head;
    }

    /**
     * 创建一个链表
     */
    public static ListNode newList2() {
        ListNode head = new ListNode(1);
        head.setNext(new ListNode(2));
        head.getNext().setNext(new ListNode(3));
        head.getNext().getNext().setNext(new ListNode(2));
        head.getNext().getNext().getNext().setNext(new ListNode(1));
        return head;
    }

    /**
     * 创建一个有序链表
     */
    public static ListNode newSortedList(int num) {
        ListNode head = null;
        ListNode last = null;
        for (int i = 1; i <= num; i++) {
            if (null == head) {
                head = new ListNode(i);
                last = head;
            } else {
                last.setNext(new ListNode(i));
                last = last.getNext();
            }
        }
        return head;
    }

    /**
     * 创建一颗二叉树
     */
    public static BinaryNode newBinary() {
        BinaryNode root = new BinaryNode(1);
        root.setLeft(new BinaryNode(2));
        root.setRight(new BinaryNode(3));
        root.getLeft().setLeft(new BinaryNode(4));
        root.getLeft().setRight(new BinaryNode(5));
        root.getRight().setLeft(new BinaryNode(6));
        root.getRight().setRight(new BinaryNode(7));
        return root;
    }
}