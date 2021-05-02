package array;

import java.util.Arrays;

/**
 * @author wukailai
 * @date 2020/07/05 16:19
 * @description 升序数组中，两数之和搜索
 */

public class TwoNumSumSearchSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(find(arr, 4)));
    }

    private static int[] find(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            if (a[i] + a[j] == target) {
                return new int[] {i, j};
            }
            while (i < j && a[i] + a[j] > target) {
                j--;
            }
            while (i < j && a[i] + a[j] < target) {
                i++;
            }
        }
        return null;
    }
}