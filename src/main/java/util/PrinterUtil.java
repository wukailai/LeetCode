package util;

import java.util.Arrays;

/**
 * 打印工具类
 */

public class PrinterUtil {
    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void printArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]);
                if (j == a[0].length - 1) {
                    System.out.println();
                } else {
                    System.out.print(" ");
                }
            }
        }
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
