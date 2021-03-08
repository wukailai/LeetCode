package array;

/**
 * 子数组之和大于等于给定值的最小长度
 */

public class SubArraySumMinLen {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(find(arr, target));
    }

    /**
     * 双指针解法
     */
    private static int find(int[] a, int target) {
        int result = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        while (end < a.length) {
            sum += a[end];
            while (sum >= target) {
                result = Math.min(result, end - start + 1);
                sum -= a[start];
                start++;
            }
            end++;
        }
        return result;
    }
}