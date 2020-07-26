package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在一个有序数组中找出所有两数之和等于0的下标
 */

public class FindTwoSumZeroIndexSorted {
    public static void main(String[] args) {
        int[] arr = new int[] {-2, -1, -1, 0, 1, 2, 3};
        List<int[]> list = find(arr);
        for (int[] a : list) {
            System.out.println(Arrays.toString(a));
        }
    }

    private static List<int[]> find(int[] a) {
        List<int[]> list = new ArrayList();
        int start = 0;
        int end = a.length - 1;
        while (start < end) {
            if (a[start] > 0 || a[end] < 0) {
                break;
            }
            if (a[start] + a[end] == 0) {
                list.add(new int[] {start, end});
                while (a[end] == a[end - 1]) {
                    list.add(new int[] {start, end - 1});
                    end--;
                }
                while (a[start] == a[start + 1]) {
                    list.add(new int[] {start + 1, end});
                    start++;
                }
                start++;
                end--;
            }
            while (a[start] + a[end] > 0 && start < end) {
                end--;
            }
            while (a[start] + a[end] < 0 && start < end) {
                start++;
            }
        }
        return list;
    }
}