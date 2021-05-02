package tree;

import util.BinaryNode;
import util.GeneratorUtil;

/**
 * @author wukailai
 * @date 2020/07/05 15:08
 * @description 二叉搜索树：左子树节点的值均小于根节点的值，右子树节点的值均大于根节点的值
 */

public class BinarySearchTree {
    public static void main(String[] args) {
        BinaryNode root = GeneratorUtil.newSortBinary();
        System.out.println(search(root, 9));
        System.out.println(search(root, 11));
    }

    private static int search(BinaryNode root, int target) {
        BinaryNode node = root;
        while (node != null) {
            if (node.getVal() == target) {
                return node.getVal();
            }
            while (node != null && node.getVal() < target) {
                node = node.getRight();
            }
            while (node != null && node.getVal() > target) {
                node = node.getLeft();
            }
        }
        return -1;
    }
}