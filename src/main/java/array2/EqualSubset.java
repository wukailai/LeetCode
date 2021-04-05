package array2;

/**
 * 分割等和子集
 */

public class EqualSubset {
    public static void main(String[] args) {
        int[] arr1 = new int[] {1, 5, 11, 5};
        int[] arr2 = new int[] {1, 2, 3, 5};
        System.out.println(isSatisfy(arr1));
        System.out.println(isSatisfy(arr2));
    }

    private static boolean isSatisfy(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[][] result = new boolean[a.length][target + 1];
        // 初始化数组
        if (a[0] <= target) {
            result[0][a[0]] = true;
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (a[i] == j) {
                    result[i][j] = true;
                    continue;
                }
                result[i][j] = result[i - 1][j] || result[i - 1][target - a[i]];
            }
        }
        return result[a.length - 1][target];
    }
}