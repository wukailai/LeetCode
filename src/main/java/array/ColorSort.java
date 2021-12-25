package array;

import util.CommonUtil;

import java.util.Arrays;

/**
 * 红白蓝三色排序
 */

public class ColorSort {
    public static void main(String[] args) {
        int[] arr = new int[] {0, 1, 2, 0, 1, 2, 0, 0, 2, 2, 1};
        //sort(arr);
        sort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] a) {
        int red = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                CommonUtil.swapIntArray(a, i, red);
                red++;
            }
        }
        int blue = a.length - 1;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == 2) {
                CommonUtil.swapIntArray(a, i, blue);
                blue--;
            }
        }
    }

    private static void sort2(int[] a) {
        int red = 0;
        int blue = a.length - 1;
        int i = 0;
        while (i <= blue) {
            if (a[i] == 0) {
                CommonUtil.swapIntArray(a, i, red);
                // 这里i可以往前走是因为从左边换过来的数已经看见了
                red++;
                i++;
            } else if (a[i] == 2) {
                CommonUtil.swapIntArray(a, i, blue);
                // 这里i不能往前走是因为从右边换过来的数不可见
                blue--;
            } else {
                i++;
            }
        }
    }
}