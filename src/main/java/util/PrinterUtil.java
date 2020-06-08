package util;

import java.util.Arrays;

/**
 * 打印工具类
 */

public class PrinterUtil {
    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void printList(ListNode head) {
        if (null == head) {
            return;
        }
        ListNode node = head;
        while (node != null) {
            System.out.print(node.getVal());
            node = node.getNext();
            if (node != null) {
                System.out.print(" > ");
            } else {
                System.out.println();
            }
        }
    }
}
