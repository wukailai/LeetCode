package util;

/**
 * 普通工具类
 */

public class CommonUtil {
    /**
     * 数组交换
     */
    public static void swapIntArray(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}