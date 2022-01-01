package array;

import java.util.Arrays;

/**
 * 合并有序数组
 */

public class MergeSortArray {
    public static void main(String[] args) {
        int[] a1 = new int[] {2, 5, 8, 14, 19};
        int[] a2 = new int[] {1, 3, 9, 10, 17, 20, 21};
        System.out.println(Arrays.toString(merge(a1, a2)));
    }

    private static int[] merge(int[] a1, int[] a2) {
        if (null == a1) {
            return a2;
        }
        if (null == a1) {
            return a2;
        }
        int[] a = new int[a1.length + a2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a1.length && j < a2.length) {
            if (a1[i] <= a2[j]) {
                a[k++] = a1[i++];
            } else {
                a[k++] = a2[j++];
            }
        }
        while (i < a1.length) {
            a[k++] = a1[i++];
        }
        while (j < a2.length) {
            a[k++] = a2[j++];
        }
        return a;
    }
}