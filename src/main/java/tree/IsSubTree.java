package tree;

import util.BinaryNode;
import util.GeneratorUtil;

/**
 * 是否为子树
 */

public class IsSubTree {
    public static void main(String[] args) {
        BinaryNode s1 = GeneratorUtil.newBinary4();
        BinaryNode s2 = GeneratorUtil.newBinary5();
        BinaryNode t = GeneratorUtil.newBinary6();
        System.out.println(isSubTree(s1, t));
        System.out.println(isSubTree(s2, t));
    }

    private static boolean isSubTree(BinaryNode s, BinaryNode t) {
        if (null == s && null == t) {
            return true;
        }
        if (null == s || null == t) {
            return false;
        }
        if (isSame(s, t)) {
            return true;
        }
        return isSubTree(s.getLeft(), t) || isSubTree(s.getRight(), t);
    }

    private static boolean isSame(BinaryNode s, BinaryNode t) {
        if (null == s && null == t) {
            return true;
        }
        if (null == s || null == t) {
            return false;
        }
        if (s.getVal() != t.getVal()) {
            return false;
        }
        return isSame(s.getLeft(), t.getLeft()) && isSame(s.getRight(), t.getRight());
    }
}