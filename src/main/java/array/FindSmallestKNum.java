package array;

import util.CommonUtil;
import util.GeneratorUtil;

import java.util.Arrays;

/**
 * 找出数组中最小的K个值
 */

public class FindSmallestKNum {
    public static void main(String[] args) {
        int[] arr = GeneratorUtil.newIntArray();
        int k = 3;
        int[] result = getSmallestK(arr, k);
        System.out.println(Arrays.toString(result));
    }

    private static int[] getSmallestK(int[] a, int k) {
        //构建大顶堆
        for (int i = k / 2 - 1; i >= 0; i--) {
            adjustHeap(a, i, k);
        }
        for (int i = k; i < a.length; i++) {
            if (a[i] >= a[0]) {
                continue;
            }
            a[0] = a[i];
            //调整大顶堆
            adjustHeap(a, 0, k);
        }
        return Arrays.copyOfRange(a, 0, k);
    }

    /**
     * 调整大顶堆
     */
    private static void adjustHeap(int[] a, int i, int len) {
        for (int j = 2 * i + 1; j < len; j++) {
            if (a[j] < a[j + 1] && j + 1 < len) {
                j++;
            }
            if (a[i] >= a[j]) {
                break;
            }
            CommonUtil.swapIntArray(a, i, j);
            i = j;
        }
    }
}