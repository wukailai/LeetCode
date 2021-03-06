package tree;

import util.BinaryNode;
import util.GeneratorUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取二叉树宽度
 */

public class GetBinaryTreeWidth {
    public static void main(String[] args) {
        BinaryNode root = GeneratorUtil.newBinary();
        System.out.println(getWidth(root));
    }

    private static int getWidth(BinaryNode root) {
        List<BinaryNode> list = new ArrayList();
        list.add(root);
        BinaryNode lastNode = root;
        BinaryNode last = root;
        int width = Integer.MIN_VALUE;
        int temp = 0;
        while (!list.isEmpty()) {
            BinaryNode node = list.remove(0);
            temp++;
            if (node.getLeft() != null) {
                list.add(node.getLeft());
                lastNode = node.getLeft();
            }
            if (node.getRight() != null) {
                list.add(node.getRight());
                lastNode = node.getRight();
            }
            if (node == last) {
                last = lastNode;
                if (temp > width) {
                    width = temp;
                }
                temp = 0;
            }
        }
        return width;
    }
}