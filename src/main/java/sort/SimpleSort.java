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
        insertSort(arr);
        //selectSort(arr);
        //bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序
     */
    private static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            boolean flag = false;
            int j;
            for (j = i - 1; j >= 0 && a[j] > a[i]; j--) {
                a[j + 1] = a[j];
                flag = true;
            }
            if (flag) {
                a[j] = temp;
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
        for (int j = 0; j < a.length - 1; j++) {
            for (int i = 0; i < a.length - j - 1; i++) {
                if (a[i] > a[i + 1]) {
                    CommonUtil.swapIntArray(a, i , i + 1);
                }
            }
        }
    }
}