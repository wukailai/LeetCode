package tree;

/**
 * 不同的二叉搜索树总颗数
 */

public class BSTNum {
    public static void main(String[] args) {
        System.out.println(getSum(13));
    }

    private static int getSum(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                result[i] += result[j - 1] * result[i - j];
            }
        }
        return result[n];
    }
}