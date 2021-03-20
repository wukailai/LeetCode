package array;

import util.CommonUtil;

import java.util.Arrays;

/**
 * 红白蓝三色排序
 */

public class ColorSort {
    public static void main(String[] args) {
        int[] arr = new int[] {0, 1, 2, 0, 1, 2, 0, 0, 2, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] a) {
        int red = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0 && i != red) {
                CommonUtil.swapIntArray(a, i, red);
                red++;
            }
        }
        int blue = a.length - 1;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == 2 && i != blue) {
                CommonUtil.swapIntArray(a, i, blue);
                blue--;
            }
        }
    }
}