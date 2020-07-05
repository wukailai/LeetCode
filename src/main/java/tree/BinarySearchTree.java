package tree;

import util.BinaryNode;

/**
 * @author wukailai
 * @date 2020/07/05 15:08
 * @description 二叉搜索树
 */
public class BinarySearchTree {
    public static void main(String[] args) {

    }

    private static int search(BinaryNode root, int target) {
        BinaryNode node = root;
        while (node != null) {
            if (node.getVal() == target) {
                return node.getVal();
            } else if (target < node.getVal()) {
                node = node.getLeft();
            } else {
                node.getRight();
            }
        }
        return -1;
    }
}