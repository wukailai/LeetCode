package array2;

import util.ArrayUtil;

/**
 * 最大正方形
 */

public class MaxSquare {
    public static void main(String[] args) {
        int[][] arr = ArrayUtil.buildArray();
        System.out.println(getMax(arr));
    }

    /**
     * 使用动态规划
     */
    private static int getMax(int[][] a) {
        int[][] dp = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            if (a[i][0] == 0) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < a[0].length; i++) {
            if (a[0][i] == 0) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = 1;
            }
        }
        int result = 0;
        for (int i = 1; i < a.length - 1; i++) {
            for (int j = 1; j < a[0].length - 1; j++) {
                if (a[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result * result;
    }
}