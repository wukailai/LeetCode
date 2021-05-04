package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 找出最长的连续子序列
 */

public class FindLongestSequenceInRow {
    public static void main(String[] args) {
        int[] arr = new int[] {100, 4, 200, 1, 3, 2};
        System.out.println(find(arr));
    }

    private static int find(int[] a) {
        int result = 1;
        Set<Integer> set = new HashSet<>();
        for (int i : a) {
            set.add(i);
        }
        for (int i : set) {
            if (set.contains(i - 1)) {
                continue;
            }
            int start = i;
            while (set.contains(start + 1)) {
                start++;
            }
            result = Math.max(result, start - i + 1);
        }
        return result;
    }
}