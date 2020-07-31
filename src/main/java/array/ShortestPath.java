package array;

import util.PrinterUtil;

/**
 * 动态规划解决最短路径问题
 */

public class ShortestPath {
    public static void main(String[] args) {
        int[][] arr = new int[][] {{2, 3, 7, 5}, {1, 3 ,4, 6}, {5, 6, 3, 2}, {9, 8, 3, 1}};
        PrinterUtil.printArray(arr);
        System.out.println(findShortestPath(arr));
    }

    private static int findShortestPath(int[][] a) {
        //初始化
        int[][] dp = new int[a.length][a[0].length];
        dp[0][0] = a[0][0];
        for (int i = 1; i < a[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + a[0][i];
        }
        for (int i = 1; i < a.length; i++) {
            dp[i][0] = dp[i - 1][0] + a[i][0];
        }
        //动态规划
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + a[i][j];
            }
        }
        System.out.println("=================================");
        PrinterUtil.printArray(dp);
        return dp[a.length - 1][a[0].length - 1];
    }
}