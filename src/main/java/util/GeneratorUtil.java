package util;

/**
 * 生成工具类
 */

public class GeneratorUtil {
    /**
     * 新建一个数组
     */
    public static int[] newIntArray() {
        return new int[] {1, 3, 6, 4, 5, 2, 2, 2};
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
     * 创建一个链表
     */
    public static ListNode newList3() {
        ListNode head = new ListNode(1);
        head.setNext(new ListNode(3));
        head.getNext().setNext(new ListNode(5));
        head.getNext().getNext().setNext(new ListNode(7));
        head.getNext().getNext().getNext().setNext(new ListNode(8));
        return head;
    }

    /**
     * 创建一个链表
     */
    public static ListNode newList4() {
        ListNode head = new ListNode(2);
        head.setNext(new ListNode(4));
        head.getNext().setNext(new ListNode(6));
        head.getNext().getNext().setNext(new ListNode(9));
        head.getNext().getNext().getNext().setNext(new ListNode(10));
        return head;
    }

    /**
     * 创建一个链表
     */
    public static ListNode newList5() {
        ListNode head = new ListNode(6);
        head.setNext(new ListNode(4));
        head.getNext().setNext(new ListNode(6));
        head.getNext().getNext().setNext(new ListNode(2));
        head.getNext().getNext().getNext().setNext(new ListNode(3));
        return head;
    }

    /**
     * 创建一个链表
     */
    public static ListNode newList6() {
        ListNode head = new ListNode(6);
        head.setNext(new ListNode(5));
        head.getNext().setNext(new ListNode(5));
        head.getNext().getNext().setNext(new ListNode(5));
        head.getNext().getNext().getNext().setNext(new ListNode(4));
        head.getNext().getNext().getNext().getNext().setNext(new ListNode(2));
        head.getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(3));
        head.getNext().getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(3));
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
        root.getLeft().setLeft(new BinaryNode(1));
        root.getLeft().setRight(new BinaryNode(5));
        root.getRight().setLeft(new BinaryNode(2));
        root.getRight().setRight(new BinaryNode(7));
        return root;
    }

    /**
     * 创建一颗二叉树
     */
    public static BinaryNode newBinary2() {
        BinaryNode root = new BinaryNode(1);
        root.setLeft(new BinaryNode(2));
        root.setRight(new BinaryNode(3));
        root.getLeft().setLeft(new BinaryNode(4));
        root.getLeft().setRight(new BinaryNode(5));
        root.getRight().setLeft(new BinaryNode(6));
        root.getRight().setRight(new BinaryNode(7));
        return root;
    }

    /**
     * 创建一颗二叉树
     */
    public static BinaryNode newBinary3() {
        BinaryNode root = new BinaryNode(1);
        root.setLeft(new BinaryNode(3));
        root.setRight(new BinaryNode(2));
        root.getLeft().setLeft(new BinaryNode(7));
        root.getLeft().setRight(new BinaryNode(6));
        root.getRight().setLeft(new BinaryNode(5));
        root.getRight().setRight(new BinaryNode(4));
        return root;
    }

    /**
     * 创建一颗二叉树
     */
    public static BinaryNode newBinary4() {
        BinaryNode root = new BinaryNode(3);
        root.setLeft(new BinaryNode(4));
        root.setRight(new BinaryNode(5));
        root.getLeft().setLeft(new BinaryNode(1));
        root.getLeft().setRight(new BinaryNode(2));
        return root;
    }

    /**
     * 创建一颗二叉树
     */
    public static BinaryNode newBinary5() {
        BinaryNode root = new BinaryNode(3);
        root.setLeft(new BinaryNode(4));
        root.setRight(new BinaryNode(5));
        root.getLeft().setLeft(new BinaryNode(1));
        root.getLeft().setRight(new BinaryNode(2));
        root.getLeft().getRight().setLeft(new BinaryNode(0));
        return root;
    }

    /**
     * 创建一颗二叉树
     */
    public static BinaryNode newBinary6() {
        BinaryNode root = new BinaryNode(4);
        root.setLeft(new BinaryNode(1));
        root.setRight(new BinaryNode(2));
        return root;
    }

    /**
     * 创建一颗二叉树
     */
    public static BinaryNode newBinary7() {
        BinaryNode root = new BinaryNode(10);
        root.setLeft(new BinaryNode(5));
        root.setRight(new BinaryNode(-3));
        root.getLeft().setLeft(new BinaryNode(3));
        root.getLeft().setRight(new BinaryNode(2));
        root.getRight().setRight(new BinaryNode(8));
        root.getLeft().getLeft().setLeft(new BinaryNode(-3));
        root.getLeft().getLeft().setRight(new BinaryNode(-2));
        root.getLeft().getRight().setRight(new BinaryNode(1));
        return root;
    }

    /**
     * 创建一颗二叉树
     */
    public static BinaryNode newBinary8() {
        BinaryNode root = new BinaryNode(2);
        root.setLeft(new BinaryNode(1));
        root.setRight(new BinaryNode(3));
        return root;
    }

    /**
     * 创建一颗二叉树
     */
    public static BinaryNode newBinary9() {
        BinaryNode root = new BinaryNode(2);
        root.setLeft(new BinaryNode(1));
        root.setRight(new BinaryNode(1));
        root.getLeft().setLeft(new BinaryNode(3));
        root.getLeft().setRight(new BinaryNode(4));
        root.getRight().setLeft(new BinaryNode(4));
        root.getRight().setRight(new BinaryNode(3));
        return root;
    }

    /**
     * 创建一颗二叉搜索树
     */
    public static BinaryNode newSortBinary() {
        BinaryNode root = new BinaryNode(12);
        root.setLeft(new BinaryNode(5));
        root.setRight(new BinaryNode(18));
        root.getLeft().setLeft(new BinaryNode(2));
        root.getLeft().setRight(new BinaryNode(9));
        root.getRight().setLeft(new BinaryNode(15));
        root.getRight().setRight(new BinaryNode(19));
        root.getRight().getLeft().setRight(new BinaryNode(17));
        root.getRight().getLeft().getRight().setLeft(new BinaryNode(16));
        return root;
    }
}