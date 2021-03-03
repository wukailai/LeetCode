package sort;

import java.util.Arrays;

/**
 * @author wukailai
 * @date 2020/07/10 10:58
 * @description 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 2, 6, 5, 4, 7, 9};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] a, int start, int end) {
        if (start < end) {
            int mid = (end - start) / 2 + start;
            mergeSort(a, start, mid);
            mergeSort(a, mid + 1, end);
            merge(a, start, mid, end);
        }
    }

    /**
     * 合并
     */
    private static void merge(int[] a, int left, int mid, int right) {
        int[] temp = new int[a.length];
        int p1 = left;
        int p2 = mid + 1;
        int k = left;
        while (p1 <= mid && p2 <= right) {
            if (a[p1] < a[p2]) {
                temp[k++] = a[p1++];
            } else {
                temp[k++] = a[p2++];
            }
        }
        while (p1 <= mid) {
            temp[k++] = a[p1++];
        }
        while (p2 <= right) {
            temp[k++] = a[p2++];
        }
        for (int i = left; i <= right; i++) {
            a[i] = temp[i];
        }
    }
}