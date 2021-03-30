package array2;

import util.ArrayUtil;

/**
 * 旋转二维数组
 */

public class RotateImage {
    public static void main(String[] args) {
        int[][] arr = ArrayUtil.buildSearchMatrix();
        ArrayUtil.print(arr);
        System.out.println("================");
        // clockWise(arr);
        antiClockWise(arr);
        ArrayUtil.print(arr);
    }

    /**
     * 顺时针
     * 行交换 + 对位互换
     */
    private static void clockWise(int[][] a) {
        exchangeRow(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                ArrayUtil.swap(a, i, j, j, i);
            }
        }
    }

    /**
     * 逆时针
     * 列交换 + 对位互换
     */
    private static void antiClockWise(int[][] a) {
        exchangeColumn(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                ArrayUtil.swap(a, i, j, j, i);
            }
        }
    }

    private static void exchangeRow(int[][] a) {
        int n = a.length;
        for (int i = 0; i <= (n - 1) / 2; i++) {
            for (int j = 0; j < a[0].length; j++) {
                ArrayUtil.swap(a, i, j, n - 1 - i, j);
            }
        }
    }

    private static void exchangeColumn(int[][] a) {
        int n = a[0].length;
        for (int i = 0; i <= (n - 1) / 2; i++) {
            for (int j = 0; j < a.length; j++) {
                ArrayUtil.swap(a, j, i, j, n - 1 - i);
            }
        }
    }
}