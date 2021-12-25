package array;

/**
 * 硬币兑换2（硬币可以复用）
 * 找出所有的硬币组合
 */

public class CoinExchange2 {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 5};
        int target = 5;
        System.out.println(exchange3(arr, target));
    }

    private static int exchange(int[] a, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int coin : a) {
            for (int i = coin; i <= target; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[target];
    }

    private static int exchange2(int[] a, int target) {
        int[][] dp = new int[a.length + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= a.length; i++) {
            for (int j = 0; j <= target; j++) {
                for (int k = 0; k <= j / a[i - 1]; k++) {
                    dp[i][j] += dp[i - 1][j - k * a[i - 1]];
                }
            }
        }
        return dp[a.length][target];
    }

    private static int exchange3(int[] a, int target) {
        int[][] dp = new int[a.length + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= a.length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j] + (j - a[i - 1] >= 0 ? dp[i][j - a[i - 1]] : 0);
            }
        }
        return dp[a.length][target];
    }
}