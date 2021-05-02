package tree;

import util.BinaryNode;
import util.GeneratorUtil;

/**
 * 判断二叉树是否为对称二叉树
 */

public class SymmetricTree {
    public static void main(String[] args) {
        System.out.println(isSymmetricTree(GeneratorUtil.newBinary2(), GeneratorUtil.newBinary3()));
        System.out.println(isSymmetricTree(GeneratorUtil.newBinary(), GeneratorUtil.newBinary2()));
    }

    private static boolean isSymmetricTree(BinaryNode root1, BinaryNode root2) {
        if (null == root1 && null == root2) {
            return true;
        }
        if (null == root1 || null == root2) {
            return false;
        }
        if (root1.getVal() != root2.getVal()) {
            return false;
        }
        return isSymmetricTree(root1.getLeft(), root2.getRight()) && isSymmetricTree(root1.getRight(), root2.getLeft());
    }
}