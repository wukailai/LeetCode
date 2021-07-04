package array;

/**
 * 硬币兑换2（硬币可以复用）
 * 找出所有的硬币组合
 */

public class CoinExchange2 {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 5};
        int target = 5;
        System.out.println(exchange(arr, target));
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
}