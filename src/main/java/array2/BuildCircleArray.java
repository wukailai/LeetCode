package array2;

import util.ArrayUtil;

/**
 * 构建同心圆二维数组
 */

public class BuildCircleArray {
    public static void main(String[] args) {
        int[][] result = build(5);
        ArrayUtil.print(result);
    }

    private static int[][] build(int n) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[i][j] = Math.min(getValue(i, n), getValue(j, n));
                if (i != j) {
                    result[j][i] = result[i][j];
                }
            }
        }
        return result;
    }

    private static int getValue(int i, int n) {
        if (n - 1 - i <= i - 0) {
            return n - i;
        } else {
            return i + 1;
        }
    }
}