package array;

/**
 * 达到终点所有路径计数
 */

public class UniquePathCount {
    public static void main(String[] args) {
        System.out.println(getPathCount(1, 2));
        System.out.println(getPathCount(3, 3));
    }

    private static int getPathCount(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[j - 1][i];
            }
        }
        return dp[m - 1][n - 1];
    }
}