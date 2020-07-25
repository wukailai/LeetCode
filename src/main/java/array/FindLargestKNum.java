package array;

import util.CommonUtil;
import util.GeneratorUtil;

import java.util.Arrays;

/**
 * 找出数组中最大的K个值
 */

public class FindLargestKNum {
    public static void main(String[] args) {
        int[] arr = GeneratorUtil.newIntArray();
        int k = 3;
        int[] result = getLLargestK(arr, k);
        System.out.println(Arrays.toString(result));
    }

    private static int[] getLLargestK(int[] a, int k) {
        // 构建小顶堆
        for (int i = k / 2 - 1; i >= 0; i--) {
            adjustHeap(a, i, k);
        }
        for (int i = k; i < a.length; i++) {
            if (a[i] <= a[0]) {
                continue;
            }
            //替换
            a[0] = a[i];
            //调整堆
            adjustHeap(a, 0, k);
        }
        return Arrays.copyOfRange(a, 0, k);
    }

    private static void adjustHeap(int[] a, int i, int len) {
        for (int j = 2 * i + 1; j < len; j = 2 * j + 1) {
            if (a[j + 1] < a[j]) {
                j++;
            }
            if (a[i] <= a[j]) {
                break;
            }
            CommonUtil.swapIntArray(a, i, j);
            i = j;
        }
    }
}