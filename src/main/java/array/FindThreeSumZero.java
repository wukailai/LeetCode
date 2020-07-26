package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找出三数之和为0的数
 */

public class FindThreeSumZero {
    public static void main(String[] args) {
        int[] arr = new int[] {-1, 0, 1, 2, -1, -4, -1};
        List<int[]> list = find(arr);
        for (int[] a : list) {
            System.out.println(Arrays.toString(a));
        }
    }

    /**
     * 先排序
     */
    private static List<int[]> find(int[] a) {
        List<int[]> list = new ArrayList();
        Arrays.sort(a);
        for (int i = 0; i < a.length - 2; i++) {
            if (a[i] > 0) {
                break;
            }
            if (i > 0 && a[i] == a[i - 1]) {
                continue;
            }
            int target = -a[i];
            int start = i + 1;
            int end = a.length - 1;
            while (start < end) {
                if (a[start] + a[end] == target) {
                    list.add(new int[] {a[i], a[start], a[end]});
                    while (a[start] == a[start + 1] && start + 1 < end) {
                        start++;
                    }
                    while (a[end] == a[end - 1] && start < end - 1) {
                        end--;
                    }
                    start++;
                    end--;
                }
                while (a[start] + a[end] > target && start < end) {
                    end--;
                }
                while (a[start] + a[end] < target && start < end) {
                    start++;
                }
            }
        }
        return list;
    }
}