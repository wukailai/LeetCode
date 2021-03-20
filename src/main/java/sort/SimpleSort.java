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
        int[] arr = new int[] {1, 3, 2, 6, -1, 4, 7, 9};
        insertSort(arr);
        //selectSort(arr);
        //bubbleSort(arr);
        insertSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序
     */
    private static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] >= a[i - 1]) {
                continue;
            }
            int temp = a[i];
            int index = getIndex(a, 0, i - 1, a[i]);
            for (int j = i; j > index; j--) {
                a[j] = a[j - 1];
            }
            a[index] = temp;
        }
    }

    /**
     * 插入排序第二种解法
     */
    private static void insertSort2(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                } else {
                    break;
                }
            }
        }
    }

    private static int getIndex(int[] a, int start, int end, int target) {
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
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