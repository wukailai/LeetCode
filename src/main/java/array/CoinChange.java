package array;

/**
 * 硬币兑换（硬币可以复用）
 * 典型的01背包问题
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
            dp[i] = target + 1;
            for (int j = 0; j < a.length; j++) {
                if (i >= a[j]) {
                    dp[i] = Math.min(dp[i], dp[i - a[j]] + 1);
                }
            }
        }
        return dp[target] > target ? -1 : dp[target];
    }
}