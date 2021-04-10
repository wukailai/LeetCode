package array;

import util.CommonUtil;
import util.PrinterUtil;

/**
 * @author wukailai
 * @date 2020/07/05 18:03
 * @description 移动0
 */
public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = new int[] {0, 1, 0, 3, 12};
        PrinterUtil.printArray(arr);
        move2(arr);
        PrinterUtil.printArray(arr);
    }

    private static void move(int[] a) {
        int i = 0;
        for (int j = 0; j < a.length; j++) {
            if (a[j] != 0) {
                a[i] = a[j];
                i++;
            }
        }
        for (int j = i; j < a.length; j++) {
            a[j] = 0;
        }
    }

    private static void move2(int[] a) {
        int i = 0;
        for (int j = 0; j < a.length; j++) {
            if (a[j] != 0 && i != j) {
                CommonUtil.swapIntArray(a, i, j);
                i++;
            }
        }
    }
}