package array;

/**
 * 容器存储最多的水
 */

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(getMaxWater(arr));
    }

    /**
     * 双指针解法
     */
    private static int getMaxWater(int[] a) {
        int max = 0;
        int start = 0;
        int end = a.length - 1;
        while (start < end) {
            int temp = (end - start) * Math.min(a[start], a[end]);
            if (temp > max) {
                max = temp;
            }
            if (a[start] <= a[end]) {
                start++;
            } else {
                end--;
            }
        }
        return max;
    }
}