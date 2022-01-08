package tree;

import util.BinaryNode;
import util.GeneratorUtil;

/**
 * 合并两个二叉树
 */

public class MergeTwoBinaryTree {
    public static void main(String[] args) {
        BinaryNode root1 = GeneratorUtil.newBinary();
        BinaryNode root2 = GeneratorUtil.newBinary();
        BinaryNode root = merge(root1, root2);
        PrintBinaryTree.layerPrint2(root1);
        PrintBinaryTree.layerPrint2(root2);
        PrintBinaryTree.layerPrint2(root);
    }

    private static BinaryNode merge(BinaryNode root1, BinaryNode root2) {
        if (null == root1) {
            return root2;
        }
        if (null == root2) {
            return root1;
        }
        BinaryNode newBinaryNode = new BinaryNode(root1.getVal() + root2.getVal());
        newBinaryNode.setLeft(merge(root1.getLeft(), root2.getLeft()));
        newBinaryNode.setRight(merge(root1.getRight(), root2.getRight()));
        return newBinaryNode;
    }
}