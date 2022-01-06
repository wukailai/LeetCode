package tree;

import util.BinaryNode;
import util.GeneratorUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 获取二叉树宽度
 */

public class GetBinaryTreeWidth {
    public static void main(String[] args) {
        BinaryNode root = GeneratorUtil.newBinary();
        System.out.println(getWidth(root));
    }

    private static int getWidth(BinaryNode root) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.offer(root);
        BinaryNode lastNode = root;
        BinaryNode last = root;
        int width = Integer.MIN_VALUE;
        int layerWidth = 0;
        while (!queue.isEmpty()) {
            BinaryNode node = queue.poll();
            layerWidth++;
            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
                lastNode = node.getLeft();
            }
            if (node.getRight() != null) {
                queue.offer(node.getRight());
                lastNode = node.getRight();
            }
            if (node == last) {
                last = lastNode;
                width = Math.max(width, layerWidth);
                layerWidth = 0;
            }
        }
        return width;
    }
}