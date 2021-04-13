package tree;

import util.BinaryNode;
import util.GeneratorUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 打印二叉树
 * 前序、中序、后序、按层打印
 */

public class PrintBinaryTree {
    public static void main(String[] args) {
        BinaryNode root = GeneratorUtil.newBinary();
        prePrint(root);
        System.out.println();
        prePrint2(root);
        System.out.println();
        midPrint(root);
        System.out.println();
        midPrint2(root);
        System.out.println();
        postPrint(root);
        System.out.println();
        layerPrint(root);
        System.out.println();
        layerPrint2(root);
    }

    /**
     * 前序打印
     */
    public static void prePrint(BinaryNode root) {
        if (null == root) {
            return;
        }
        System.out.print(root.getVal() + " > ");
        prePrint(root.getLeft());
        prePrint(root.getRight());
    }

    /**
     * 前序打印-非递归实现
     */
    private static void prePrint2(BinaryNode root) {
        if (null == root) {
            return;
        }
        Stack<BinaryNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryNode node = stack.pop();
            System.out.print(node.getVal() + " > ");
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
    }

    /**
     * 中序打印
     */
    public static void midPrint(BinaryNode root) {
        if (null == root) {
            return;
        }
        midPrint(root.getLeft());
        System.out.print(root.getVal() + " > ");
        midPrint(root.getRight());
    }

    /**
     * 中序打印-非递归实现
     */
    public static void midPrint2(BinaryNode root) {
        if (null == root) {
            return;
        }
        Stack<BinaryNode> stack = new Stack();
        BinaryNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            //压左子树
            while (cur != null) {
                stack.push(cur);
                cur = cur.getLeft();
            }
            //压完一波左子树就可以输出了
            BinaryNode node = stack.pop();
            System.out.print(node.getVal() + " > ");
            if (node.getRight() != null) {
                cur = node.getRight();
            }
        }
    }

    /**
     * 后序打印
     */
    public static void postPrint(BinaryNode root) {
        if (null == root) {
            return;
        }
        postPrint(root.getLeft());
        postPrint(root.getRight());
        System.out.print(root.getVal() + " > ");
    }

    /**
     * 后序打印-非递归实现
     */
    public static void postPrint2(BinaryNode root) {
        if (null == root) {
            return;
        }
    }

    /**
     * 按层打印，简单好理解
     */
    public static void layerPrint(BinaryNode root) {
        LinkedList<BinaryNode> list = new LinkedList();
        list.add(root);
        while (!list.isEmpty()) {
            BinaryNode node = list.poll();
            System.out.print(node.getVal() + " ");
            if (node.getLeft() != null) {
                list.add(node.getLeft());
            }
            if (node.getRight() != null) {
                list.add(node.getRight());
            }
        }
    }

    public static void layerPrint2(BinaryNode root) {
        List<BinaryNode> list = new ArrayList();
        list.add(root);
        BinaryNode last = root;
        BinaryNode lastNode = root;
        while (!list.isEmpty()) {
            BinaryNode node = list.remove(0);
            System.out.print(node.getVal());
            if (node.getLeft() != null) {
                list.add(node.getLeft());
                lastNode = node.getLeft();
            }
            if (node.getRight() != null) {
                list.add(node.getRight());
                lastNode = node.getRight();
            }
            if (node == last) {
                last = lastNode;
                System.out.println();
            } else {
                System.out.print(" ");
            }
        }
    }
}