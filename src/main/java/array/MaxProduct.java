package array;

public class MaxProduct {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 3, -2, 4, 5};
        System.out.println(getMax(arr));
    }

    /**
     * 动态规划
     */
    private static int getMax(int[] a) {
        if (null == a || a.length == 0) {
            return 0;
        }
        int[] dp = new int[a.length];
        dp[0] = a[0];
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            dp[i] = Math.max(dp[i - 1] * a[i], a[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}