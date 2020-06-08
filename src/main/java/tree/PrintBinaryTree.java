package tree;

import util.BinaryNode;
import util.GeneratorUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印二叉树
 * 前序、中序、后序、按层打印
 */

public class PrintBinaryTree {
    public static void main(String[] args) {
        BinaryNode root = GeneratorUtil.newBinary();
        prePrint(root);
        System.out.println();
        midPrint(root);
        System.out.println();
        postPrint(root);
        System.out.println();
        layerPrint(root);
    }

    /**
     * 前序打印
     */
    private static void prePrint(BinaryNode root) {
        if (null == root) {
            return;
        }
        System.out.print(root.getVal() + " > ");
        prePrint(root.getLeft());
        prePrint(root.getRight());
    }

    /**
     * 中序打印
     */
    private static void midPrint(BinaryNode root) {
        if (null == root) {
            return;
        }
        midPrint(root.getLeft());
        System.out.print(root.getVal() + " > ");
        midPrint(root.getRight());
    }

    /**
     * 中序打印
     */
    private static void postPrint(BinaryNode root) {
        if (null == root) {
            return;
        }
        postPrint(root.getLeft());
        postPrint(root.getRight());
        System.out.print(root.getVal() + " > ");
    }

    /**
     * 按层打印
     */
    private static void layerPrint(BinaryNode root) {
        List<BinaryNode> list = new ArrayList();
        list.add(root);
        BinaryNode lastNode = root;
        BinaryNode last = root;
        while (!list.isEmpty()) {
            BinaryNode node = list.remove(0);
            if (node.getLeft() != null) {
                list.add(node.getLeft());
                lastNode = node.getLeft();
            }
            if (node.getRight() != null) {
                list.add(node.getRight());
                lastNode = node.getRight();
            }
            System.out.print(node.getVal());
            if (node == last) {
                System.out.println();
                last = lastNode;
            } else {
                System.out.print(" ");
            }
        }
    }
}