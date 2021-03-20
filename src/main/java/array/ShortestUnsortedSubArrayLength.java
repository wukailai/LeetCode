package array;

import java.util.Arrays;

/**
 * 最短无序连续子数组长度
 */

public class ShortestUnsortedSubArrayLength {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 6, 4, 8, 10, 9, 15};
        System.out.println(find(arr));
    }

    private static int find(int[] a) {
        int[] sa = a.clone();
        Arrays.sort(sa);
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < sa.length; i++) {
            if (a[i] != sa[i]) {
                start = Math.min(i, start);
                end = Math.max(i, end);
            }
        }
        return end >= start ? end - start + 1 : 0;
    }
}