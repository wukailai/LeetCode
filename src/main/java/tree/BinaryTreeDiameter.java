package tree;

import util.BinaryNode;
import util.GeneratorUtil;

/**
 * 二叉树的直径（直径比节点数小1）
 */

public class BinaryTreeDiameter {
    public static void main(String[] args) {
        BinaryNode root = GeneratorUtil.newBinary();
        System.out.println(getDiameter(root));
    }

    /**
     * 三种情况：
     * 1）直径包含根节点，直径 = 左子树高度 + 右子树高度；
     * 2）左子树直径；
     * 3）右子树直径；
     */
    private static int getDiameter(BinaryNode root) {
        if (null == root) {
            return 0;
        }
        int diameter = 0;
        diameter = Math.max(diameter, getHeight(root.getLeft()) + getHeight(root.getRight()));
        diameter = Math.max(diameter, getDiameter(root.getLeft()));
        diameter = Math.max(diameter, getDiameter(root.getRight()));
        return diameter;
    }

    private static int getHeight(BinaryNode root) {
        if (null == root) {
            return 0;
        }
        int leftHeight = getHeight(root.getLeft());
        int rightHeight = getHeight(root.getRight());
        return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
    }
}