package tree;

import util.BinaryNode;
import util.GeneratorUtil;

/**
 * 二叉搜索树校验
 */

public class BinaryTreeValidate {
    public static void main(String[] args) {
        BinaryNode root = GeneratorUtil.newBinary();
        PrintBinaryTree.layerPrint(root);
        System.out.println(validate(root));
        BinaryNode root1 = GeneratorUtil.newSortBinary();
        PrintBinaryTree.layerPrint(root1);
        System.out.println(validate(root1));

    }

    private static boolean validate(BinaryNode root) {
        if (null == root) {
            return true;
        }
        if (root.getLeft() != null) {
            if (root.getLeft().getVal() > root.getVal()) {
                return false;
            }
        }
        if (root.getRight() != null) {
            if (root.getRight().getVal() < root.getVal()) {
                return false;
            }
        }
        return validate(root.getLeft()) && validate(root.getRight());
    }
}