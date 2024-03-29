package tree;

import util.BinaryNode;
import util.GeneratorUtil;

/**
 * Convert BST to Greater Tree（累加树）
 */

public class ConvertBST {
    private static int sum = 0;

    public static void main(String[] args) {
        BinaryNode root = GeneratorUtil.newBinary8();
        PrintBinaryTree.layerPrint2(root);
        BinaryNode newRoot = convert(root);
        PrintBinaryTree.layerPrint2(newRoot);
    }

    private static BinaryNode convert(BinaryNode root) {
        if (root != null) {
            convert(root.getRight());
            sum += root.getVal();
            root.setVal(sum);
            convert(root.getLeft());
        }
        return root;
    }
}