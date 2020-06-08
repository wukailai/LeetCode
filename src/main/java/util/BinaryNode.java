package util;

/**
 * 二叉树节点
 */

public class BinaryNode {
    private int val;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }
}