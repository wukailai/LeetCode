package tree;

import util.TreeNode;

/**
 * 前缀树
 */

public class PrefixTree {
    public static void main(String[] args) {
        PrefixTree tree = new PrefixTree();
        tree.insert("wukailai");
        System.out.println(tree.search("wukai"));
    }

    private TreeNode root;

    public PrefixTree() {
        this.root = new TreeNode();
    }

    /**
     * 查找
     */
    public boolean search(String s) {
        TreeNode node = root;
        for (char c : s.toCharArray()) {
            if (!node.contains(c)) {
                return false;
            }
            node = node.getChild(c);
        }
        return true;
    }

    /**
     * 插入
     */
    public void insert(String s) {
        TreeNode node = root;
        for (char c : s.toCharArray()) {
            if (!node.contains(c)) {
                node.setChild(new TreeNode(c));
            }
            node = node.getChild(c);
        }
    }
}