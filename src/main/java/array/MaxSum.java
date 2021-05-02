package array;

/**
 * @author wukailai
 * @date 2020/07/05 18:27
 * @description 最大连续和，有负数，只需要记录一个状态
 */

public class MaxSum {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 3, -6, 4, 6, 2, -2, 5, -9};
        System.out.println(getMax(arr));
        System.out.println(getMax2(arr));
    }

    private static int getMax(int[] a) {
        int result = a[0];
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            max = Math.max(max + a[i], a[i]);
            // 有负数
            result = Math.max(max, result);
        }
        return result;
    }

    /**
     * 使用动态规划
     */
    private static int getMax2(int[] a) {
        int[] dp = new int[a.length];
        dp[0] = a[0];
        int max= a[0];
        for (int i = 1; i < a.length; i++) {
            dp[i] = Math.max(dp[i - 1] + a[i], a[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}