package array;

/**
 * 找出n需要最少的平方数个数
 */

public class PerfectSquare {
    public static void main(String[] args) {
        System.out.println(find(12));
        System.out.println(find(13));
    }

    /**
     * 动态规划
     */
    private static int find(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = n;
            for (int j = 1; j <= n; j++) {
                if (i - j * j >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
        }
        return dp[n];
    }
}