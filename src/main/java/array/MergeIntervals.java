package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并数组
 */

public class MergeIntervals {
    public static void main(String[] args) {
        List<int[]> list = new ArrayList();
        int[] arr1 = new int[] {1, 3};
        int[] arr2 = new int[] {2, 6};
        int[] arr3 = new int[] {8, 10};
        int[] arr4 = new int[] {15, 18};
        list.add(arr1);
        list.add(arr2);
        list.add(arr3);
        list.add(arr4);
        List<int[]> result = merge(list);
        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    private static List<int[]> merge(List<int[]> list) {
        if (null == list || list.size() == 0) {
            return new ArrayList();
        }
        List<int[]> result = new ArrayList();
        int[] cur = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            int[] arr = list.get(i);
            if (arr[0] > cur[1]) {
                result.add(cur);
                cur = arr;
            } else if (cur[1] >= arr[1]) {
                continue;
            } else if (cur[1] < arr[1]) {
                cur[1] = arr[1];
            }
        }
        // 关键
        result.add(cur);
        return result;
    }
}