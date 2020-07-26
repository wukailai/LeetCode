package array;

/**
 * 数组添加正负号使得计算之和等于目标值的次数
 */

public class AddReduceTotalNum {
    private static int count = 0;

    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 1, 1, 1};
        int target = 3;
        calculate(arr, 0, 0, target);
        System.out.println(count);
    }

    /**
     * 数组之和（可正可负）等于target
     */
    private static void calculate(int[] a, int i, int curTotal, int target) {
        if (i == a.length) {
            if (curTotal == target) {
                count++;
            }
        } else {
            calculate(a, i + 1, curTotal + a[i], target);
            calculate(a, i + 1, curTotal - a[i], target);
        }
    }
}