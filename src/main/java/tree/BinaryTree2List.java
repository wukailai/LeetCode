package tree;

import util.BinaryNode;
import util.GeneratorUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 按照前序遍历的顺序将二叉树转换为链表
 */

public class BinaryTree2List {
    public static void main(String[] args) {
        BinaryNode root = GeneratorUtil.newBinary2();
        PrintBinaryTree.layerPrint2(root);
        BinaryNode newRoot = convert(root);
        PrintBinaryTree.layerPrint2(newRoot);
    }

    private static BinaryNode convert(BinaryNode root) {
        List<BinaryNode> list = new ArrayList<>();
        gather(root, list);
        BinaryNode newRoot = null;
        BinaryNode right = null;
        for (int i = 0; i < list.size(); i++) {
            BinaryNode node = list.get(i);
            node.setLeft(null);
            node.setRight(null);
            if (null == newRoot) {
                newRoot = right = node;
            } else {
                right.setRight(node);
                right = right.getRight();
            }
        }
        return newRoot;
    }

    private static void gather(BinaryNode root, List<BinaryNode> list) {
        if (root != null) {
            list.add(root);
            gather(root.getLeft(), list);
            gather(root.getRight(), list);
        }
    }
}