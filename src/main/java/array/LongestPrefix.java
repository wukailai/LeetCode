package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最小数组前缀
 */

public class LongestPrefix {
    public static void main(String[] args) {
        List<int[]> list = new ArrayList();
        list.add(new int[] {1, 2, 3, 4});
        list.add(new int[] {1, 2, 3});
        list.add(new int[] {1, 2});
        int[] result = getLongestPrefix(list);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 优化方向：起始数组选择最短的数组
     */
    private static int[] getLongestPrefix(List<int[]> list) {
        if (list.size() == 0) {
            return new int[] {};
        }
        int[] result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            while (!isContains(list.get(i), result)) {
                result = Arrays.copyOfRange(result, 0, result.length - 1);
                if (result.length == 0) {
                    return new int[] {};
                }
            }
        }
        return result;
    }

    private static boolean isContains(int[] a, int[] b) {
        if (a.length < b.length) {
            return false;
        }
        for (int i = 0; i < b.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}