package sort;

import util.CommonUtil;

import java.util.Arrays;

/**
 * @author wukailai
 * @date 2020/07/10 10:38
 * @description 简单排序：插入排序、选择排序、冒泡排序
 */
public class SimpleSort {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 2, 6, 5, 4, 7, 9};
        //insertSort(arr);
        //selectSort(arr);
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序
     */
    private static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    CommonUtil.swapIntArray(a, j - 1, j);
                }
            }
        }
    }

    /**
     * 选择排序
     */
    private static void selectSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]) {
                    CommonUtil.swapIntArray(a, i, j);
                }
            }
        }
    }

    /**
     * 冒泡排序
     */
    private static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i; j < a.length - 1; j++) {
                if (a[j + 1] < a[j]) {
                    CommonUtil.swapIntArray(a, j, j + 1);
                }
            }
        }
    }
}