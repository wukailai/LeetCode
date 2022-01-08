package tree;

import util.BinaryNode;
import util.GeneratorUtil;

/**
 * Path Sum3
 */

public class PathSum3 {
    public static void main(String[] args) {
        BinaryNode root = GeneratorUtil.newBinary7();
        PrintBinaryTree.layerPrint2(root);
        System.out.println(sum(root, 8));
        System.out.println(sum2(root, 15));
        System.out.println(sum3(root, 15));
    }

    /**
     * 从任意节点出发
     */
    private static int sum(BinaryNode root, int sum) {
        if (null == root) {
            return 0;
        }
        return sum2(root, sum) + sum2(root.getLeft(), sum) + sum2(root.getRight(), sum);
    }

    /**
     * 必须从根节点出发
     */
    private static int sum2(BinaryNode root, int sum) {
        if (null == root) {
            return 0;
        }
        int result = 0;
        sum -= root.getVal();
        if (sum == 0) {
            result++;
        }
        return result + sum2(root.getLeft(), sum) + sum2(root.getRight(), sum);
    }

    /**
     * 必须从根节点到叶子节点
     */
    private static int sum3(BinaryNode root, int sum) {
        if (null == root) {
            return 0;
        }
        int result = 0;
        sum -= root.getVal();
        if (sum == 0 && isLeafNode(root)) {
            result++;
        }
        return result + sum3(root.getLeft(), sum) + sum3(root.getRight(), sum);
    }

    private static boolean isLeafNode(BinaryNode node) {
        return null == node.getLeft() && null == node.getRight();
    }
}