package util;

import java.util.ArrayList;
import java.util.List;

/**
 * 树节点
 */

public class TreeNode {
    private char value;
    private List<TreeNode> children;

    public TreeNode() {
        children = new ArrayList<>();
    }

    public TreeNode(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public TreeNode getChild(char c) {
        if (null == children) {
            return null;
        }
        for (TreeNode child : children) {
            if (child.getValue() == c) {
                return child;
            }
        }
        return null;
    }

    public void setChild(TreeNode child) {
        if (null == children) {
            children = new ArrayList<>();
        }
        children.add(child);
    }

    public boolean contains(char c) {
        if (null == children) {
            return false;
        }
        for (TreeNode child : children) {
            if (child.getValue() == c) {
                return true;
            }
        }
        return false;
    }
}