package array2;

import util.ArrayUtil;

/**
 * 二维数组查找
 * 二维数组特点：1）从左至右，依次变大；2）从上至下，依次变大；
 */

public class searchInMatrix {
    public static void main(String[] args) {
        int[][] arr = ArrayUtil.buildSearchMatrix();
        System.out.println(find(arr, 5));
        System.out.println(find(arr, 20));
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
}