package array;

import util.CommonUtil;

import java.util.Arrays;

/**
 * 下一个排列组合
 */

public class NextPermutation {
    public static void main(String[] args) {
        //int[] arr = new int[] {1, 2, 3};
        int[] arr = new int[] {1, 3, 2, 4, 5};
        find(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void find(int[] a) {
        int i = a.length - 2;
        // 找到最右边升序index
        while (i >= 0 && a[i] >= a[i + 1]) {
            i--;
        }
        // 说明找到了最右边下降的值
        if (i >= 0) {
            int j = a.length - 1;
            // 找到最右边第一个大于target的index
            while (j >= 0 && a[i] >= a[j]) {
                j--;
            }
            // 交换位置
            CommonUtil.swapIntArray(a, i, j);
            // 倒排
            reverse2End(a, i + 1);
        } else {
            reverse2End(a, 0);
        }
    }

    private static void reverse2End(int[] a, int from) {
        int start = from;
        int end = a.length - 1;
        while (start < end) {
            CommonUtil.swapIntArray(a, start++, end--);
        }
    }
}