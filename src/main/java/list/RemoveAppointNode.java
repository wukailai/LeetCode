package list;

import util.ListNode;

/**
 * 删除指定节点（节点存在且非首非尾）
 */

public class RemoveAppointNode {
    public static void main(String[] args) {
    }

    private static void remove (ListNode node) {
        node.setNext(node.getNext().getNext());
        node.setVal(node.getVal());
    }
}