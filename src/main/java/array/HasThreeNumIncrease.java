package array;

/**
 * 判断数组中是否有三个升序数字
 */

public class HasThreeNumIncrease {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 6, 1, 2, 3, 5, 4, 5};
        System.out.println(exist(arr));
        System.out.println(exist2(arr, 4));
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
        int start = 0;
        int end = 0;
        while (end < a.length) {
            if (end - start + 1 == k) {
                return true;
            }
            if (end + 1 < a.length && a[end + 1] > a[end]) {
                end++;
            } else if (end + 1 < a.length && a[end + 1] <= a[end]) {
                end = end + 1;
                start = end;
            } else {
                return false;
            }
        }
        return false;
    }
}