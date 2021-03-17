package array;

/**
 * 最大连续乘积
 */

public class MaxProduct {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 3, -2, -2, -3, 4};
        System.out.println(getMax(arr));
    }

    /**
     * 动态规划
     */
    private static int getMax(int[] a) {
        if (null == a || a.length == 0) {
            return 0;
        }
        int[] dp_max = new int[a.length];
        int[] dp_min = new int[a.length];
        dp_max[0] = a[0];
        dp_min[0] = a[0];
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            dp_min[i] = Math.min(Math.min(dp_max[i - 1] * a[i], dp_min[i - 1] * a[i]), a[i]);
            dp_max[i] = Math.max(Math.max(dp_max[i - 1] * a[i], dp_min[i - 1] * a[i]), a[i]);
            max = Math.max(dp_max[i], max);
        }
        return max;
    }
}