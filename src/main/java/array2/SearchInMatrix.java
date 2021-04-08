package array2;

import util.ArrayUtil;

/**
 * 二维数组查找
 * 二维数组特点：1）从左至右，依次变大；2）从上至下，依次变大；
 */

public class SearchInMatrix {
    public static void main(String[] args) {
        int[][] arr = ArrayUtil.buildSearchMatrix();
        System.out.println(find(arr, 5));
        System.out.println(find(arr, 20));
        System.out.println(find(arr, 11));
        System.out.println(find(arr, 110));
        System.out.println(find2(arr, 5));
        System.out.println(find2(arr, 20));
        System.out.println(find2(arr, 11));
        System.out.println(find2(arr, 110));
    }

    /**
     * 从右上角节点作为搜索的起点
     */
    private static boolean find(int[][] a, int target) {
        int row = 0;
        int column = a.length - 1;
        while (row < a[0].length && column >= 0) {
            if (a[row][column] == target) {
                return true;
            } else if (a[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    /**
     * 从左下角节点作为搜索的起点
     */
    private static boolean find2(int[][] a, int target) {
        int row = a.length - 1;
        int column = 0;
        while (row >= 0 && column < a.length) {
            if (a[row][column] == target) {
                return true;
            } else if (a[row][column] > target) {
                row--;
            } else {
                column++;
            }
        }
        return false;
    }
}