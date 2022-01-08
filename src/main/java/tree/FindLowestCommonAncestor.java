package tree;

import util.BinaryNode;
import util.GeneratorUtil;

/**
 * 找到最低共有祖先
 */

public class FindLowestCommonAncestor {
    public static void main(String[] args) {
        BinaryNode root = GeneratorUtil.newBinary2();
        BinaryNode p = root.getLeft().getLeft();
        // BinaryNode q = root.getLeft().getRight();
        BinaryNode q = root.getRight().getRight();
        BinaryNode node = find(root, p, q);
        System.out.println(node.getVal());
    }

    private static BinaryNode find(BinaryNode root, BinaryNode p, BinaryNode q) {
        if (null == root) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        BinaryNode left = find(root.getLeft(), p, q);
        BinaryNode right = find(root.getRight(), p, q);
        if (null == left) {
            return right;
        }
        if (null == right) {
            return left;
        }
        return null;
    }
}