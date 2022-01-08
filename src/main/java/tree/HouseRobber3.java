package tree;

import util.BinaryNode;
import util.GeneratorUtil;

/**
 * house robber III
 */

public class HouseRobber3 {
    public static void main(String[] args) {
        BinaryNode root = GeneratorUtil.newBinary4();
        PrintBinaryTree.layerPrint2(root);
        System.out.println(get(root));
    }

    private static int get(BinaryNode root) {
        if (null == root) {
            return 0;
        }
        int result = root.getVal();
        if (root.getLeft() != null) {
            result += get(root.getLeft().getLeft()) + get(root.getLeft().getRight());
        }
        if (root.getRight() != null) {
            result += get(root.getRight().getLeft()) + get(root.getRight().getRight());
        }
        result = Math.max(result, get(root.getLeft()) + get(root.getRight()));
        return result;
    }
}