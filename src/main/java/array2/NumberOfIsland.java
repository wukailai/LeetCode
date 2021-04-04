package array2;

import util.ArrayUtil;

/**
 * 岛屿数量
 */

public class NumberOfIsland {
    private static int result;

    public static void main(String[] args) {
        int[][] arr = ArrayUtil.buildArray();
        getNum(arr);
        System.out.println(result);
    }

    private static void getNum(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 0) {
                    continue;
                }
                result++;
                dfs(a, i, j);
            }
        }
    }

    private static void dfs(int[][] a, int i, int j) {
        if (i < 0 || j < 0 || i >= a.length || j >= a[0].length) {
            return;
        }
        if (a[i][j] == 0) {
            return;
        }
        a[i][j] = 0;
        dfs(a, i - 1, j);
        dfs(a, i + 1, j);
        dfs(a, i, j - 1);
        dfs(a, i, j + 1);
    }
}