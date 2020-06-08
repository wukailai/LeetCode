package tree;

import util.BinaryNode;
import util.GeneratorUtil;

/**
 * 获取二叉树高度
 */

public class GetBinaryTreeHeight {
    public static void main(String[] args) {
        BinaryNode root = GeneratorUtil.newBinary();
        System.out.println(getHeight(root));
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