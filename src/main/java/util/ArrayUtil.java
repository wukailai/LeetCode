package util;

/**
 * 数组工具类
 */

public class ArrayUtil {
    public static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] buildSearchMatrix() {
        return new int[][] {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
    }

    public static int[][] buildArray() {
        return new int[][] {
                {1, 0, 1, 0, 0},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 0, 0, 0}
        };
    }

    public static char[][] buildCharArray() {
        return new char[][] {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
    }

    public static void swap(int[][] a, int i1, int j1, int i2, int j2) {
        int temp = a[i1][j1];
        a[i1][j1] = a[i2][j2];
        a[i2][j2] = temp;
    }
}