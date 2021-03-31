package tree;

import util.BinaryNode;

/**
 * 已知前序、中序遍历结果（无重复元素）构建二叉树
 */

public class ConstructBinaryTreeByPreMid {
    public static void main(String[] args) {
        int[] pre = new int[] {3, 9, 20, 15, 7};
        int[] mid = new int[] {9, 3, 15, 20, 7};
        BinaryNode root = construct(pre, 0, pre.length - 1, mid, 0, mid.length - 1);
        PrintBinaryTree.layerPrint2(root);
    }

    private static BinaryNode construct(int[] pre, int preStart, int preEnd, int[] mid, int midStart, int midEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int preRoot = preStart;
        int midRoot = midStart;
        while (mid[midRoot] != pre[preStart]) {
            midRoot++;
        }
        int left_size = midRoot - midStart;
        BinaryNode root = new BinaryNode(pre[preRoot]);
        root.setLeft(construct(pre, preStart + 1, left_size + preStart, mid, midStart, midRoot - 1));
        root.setRight(construct(pre, left_size + preStart + 1, preEnd, mid, midRoot + 1, midEnd));
        return root;
    }
}