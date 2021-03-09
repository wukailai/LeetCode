package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断数组中是否有三个升序数字
 */

public class HasThreeNumIncrease {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 5, 4, 5};
        System.out.println(exist(arr));
        System.out.println(exist2(arr, 3));
    }

    private static boolean exist(int[] a) {
        if (a.length < 3) {
            return false;
        }
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (Integer i : a) {
            if (i <= first) {
                first = i;
            } else if (i <= second) {
                second = i;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 滑动窗口解法
     */
    private static boolean exist2(int[] a, int k) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            if (list.size() > 0 && a[i] <= a[i - 1]) {
                list.clear();
            }
            list.add(a[i]);
            if (list.size() >= k) {
                return true;
            }
        }
        return false;
    }
}