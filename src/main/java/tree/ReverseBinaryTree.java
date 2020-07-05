package tree;

import util.BinaryNode;
import util.GeneratorUtil;

/**
 * @author wukailai
 * @date 2020/07/05 17:53
 * @description 反转二叉树
 */
public class ReverseBinaryTree {
    public static void main(String[] args) {
        BinaryNode root = GeneratorUtil.newBinary();
        PrintBinaryTree.layerPrint(root);
        root = reverse(root);
        PrintBinaryTree.layerPrint(root);
    }

    private static BinaryNode reverse(BinaryNode root) {
        if (null == root) {
            return null;
        }
        BinaryNode left = reverse(root.getLeft());
        BinaryNode right = reverse(root.getRight());
        root.setLeft(right);
        root.setRight(left);
        return root;
    }
}