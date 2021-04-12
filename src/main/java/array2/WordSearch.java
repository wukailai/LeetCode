package array2;

import util.ArrayUtil;

/**
 * 单词搜索
 */

public class WordSearch {
    public static void main(String[] args) {
        char[][] arr = ArrayUtil.buildCharArray();
        String s1 = "ABCCED";
        String s2 = "SEE";
        String s3 = "ABCB";
        System.out.println(isExist(arr, s1));
//        System.out.println(isExist(arr, s2));
//        System.out.println(isExist(arr, s3));
    }

    private static boolean isExist(char[][] a, String s) {
        boolean[][] visited = new boolean[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (isExist(a, visited, s, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isExist(char[][] a, boolean[][] visited, String s, int i, int j, int k) {
        // 需要写在最前面
        if (k == s.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= a.length || j >= a[0].length) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        if (s.charAt(k) != a[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (isExist(a, visited, s, i - 1, j, k + 1)) {
            return true;
        }
        if (isExist(a, visited, s, i + 1, j, k + 1)) {
            return true;
        }
        if (isExist(a, visited, s, i, j - 1, k + 1)) {
            return true;
        }
        if (isExist(a, visited, s, i, j + 1, k + 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}