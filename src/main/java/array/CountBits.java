package array;

import java.util.Arrays;

/**
 * 给定一个数字n，计算0-n之间二进制表示1的个数
 */

public class CountBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(count(5)));
    }

    private static int[] count(int k) {
        int[] result = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            result[i] = countOne(i);
        }
        return result;
    }

    private static int countOne(int n) {
        int count = 0;
        while (n > 0) {
            int remain = n % 2;
            if (remain == 1) {
                count++;
            }
            n = n / 2;
        }
        return count++;
    }
}