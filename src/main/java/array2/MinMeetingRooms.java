package array2;

import java.util.Map;
import java.util.TreeMap;

/**
 * 最少会议室数量
 */

public class MinMeetingRooms {
    public static void main(String[] args) {
        int[][] arr = new int[][] {{0, 30}, {5, 10}, {15, 20}};
        int[][] arr1 = new int[][] {{7, 10}, {2, 4}};
        System.out.println(getMin(arr));
        System.out.println(getMin(arr1));
    }

    private static int getMin(int[][] arr) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] a : arr) {
            map.put(a[0], map.getOrDefault(a[0], 0) + 1);
            map.put(a[1], map.getOrDefault(a[1], 0) - 1);
        }
        int maxCount = 0;
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}