package array2;

import util.ArrayUtil;

/**
 * 总路径数，带陷阱
 */

public class TotalPath {
    public static void main(String[] args) {
        int[][] arr = ArrayUtil.buildArray2();
        System.out.println(totalPath(arr));
    }

    private static int totalPath(int[][] a) {
        int[][] dp = new int[a.length][a[0].length];
        // 初始化
        boolean rowCanPass = true;
        for (int i = 0; i < a[0].length; i++) {
            if (rowCanPass && a[0][i] == 1) {
                rowCanPass = false;
            }
            if (rowCanPass) {
                dp[0][i] = 1;
            }
        }
        boolean columnCanPass = true;
        for (int i = 0; i < a.length; i++) {
            if (columnCanPass && a[i][0] == 1) {
                columnCanPass = false;
            }
            if (columnCanPass) {
                dp[i][0] = 1;
            }
        }
        // 动态规划
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a[0].length; j++) {
                dp[i][j] = (a[i - 1][j] == 1 ? 0 : dp[i - 1][j]) + (a[i][j - 1] == 1 ? 0 : dp[i][j - 1]);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}