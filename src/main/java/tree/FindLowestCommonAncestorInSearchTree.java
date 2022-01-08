package tree;

import util.BinaryNode;
import util.GeneratorUtil;

/**
 * 二叉搜索树找到最低共有祖先
 */

public class FindLowestCommonAncestorInSearchTree {
    public static void main(String[] args) {
        BinaryNode root = GeneratorUtil.newSortBinary();
        BinaryNode p = root.getLeft().getLeft();
         BinaryNode q = root.getLeft().getRight();
//        BinaryNode q = root.getRight().getRight();
        System.out.println(find(root, p, q).getVal());
    }
    private static BinaryNode find(BinaryNode root, BinaryNode p, BinaryNode q) {
        if (p.getVal() > root.getVal() && q.getVal() > root.getVal()) {
            return find(root.getRight(), p, q);
        } else if (p.getVal() < root.getVal() && q.getVal() < root.getVal()) {
            return find(root.getLeft(), p, q);
        }
        return root;
    }
}
