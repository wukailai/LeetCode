package array;

import util.CommonUtil;
import util.PrinterUtil;

import java.util.Random;

/**
 * 打乱数组
 */

public class UpsetArray {
    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3, 4, 5};
        PrinterUtil.printArray(a);
        upset(a);
        PrinterUtil.printArray(a);
    }

    private static void upset(int[] a) {
        Random random = new Random();
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int exchange = random.nextInt(n - i - 1) + i + 1;
            CommonUtil.swapIntArray(a, i, exchange);
        }
    }
}