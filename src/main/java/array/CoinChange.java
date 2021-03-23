package array;

/**
 * 硬币兑换
 */

public class CoinChange {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 5};
        System.out.println(change(arr, 11));
    }

    private static int change(int[] a, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int i = 1; i <= target; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < a.length; j++) {
                if (i >= a[j]) {
                    dp[i] = Math.min(dp[i], dp[i - a[j]] + 1);
                }
            }
        }
        return dp[target] == Integer.MAX_VALUE ? -1 : dp[target];
    }
}