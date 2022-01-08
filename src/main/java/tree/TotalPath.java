package tree;

import util.BinaryNode;
import util.GeneratorUtil;

/**
 * 从根节点到叶子节点所有路径
 */

public class TotalPath {
    public static void main(String[] args) {
        BinaryNode root = GeneratorUtil.newBinary7();
        PrintBinaryTree.layerPrint2(root);
        System.out.println(countPath(root));
    }

    private static int countPath(BinaryNode root) {
        if (null == root) {
            return 0;
        }
        if (null == root.getLeft() && null == root.getRight()) {
            return 1;
        }
        return countPath(root.getLeft()) + countPath(root.getRight());
    }
}
