package array;

import java.util.Arrays;

/**
 * @author wukailai
 * @date 2020/07/09 18:59
 * @description 求解两个数组差值绝对值最小值
 */
public class TwoArrayMinGap {
    public static void main(String[] args) {
        int[] arr1 = new int[] {10, 42, 7, 22, 90, 11};
        int[] arr2 = new int[] {3, 5, 91};
        System.out.println(getMin(arr1, arr2));
    }

    private static int getMin(int[] arr1, int[] arr2) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(arr1);
        for (Integer i : arr2) {
            int position = getPosition(arr1, 0, arr1.length - 1, i);
            if (position == 0) {
                result = Math.min(result, arr1[0] - i);
            } else if (position == arr1.length) { //注意这里可能超出数组index之外
                result = Math.min(result, i - arr1[arr1.length - 1]);
            } else {
                //position最终落在偏大的index那一侧
                result = Math.min(Math.min(i - arr1[position - 1], arr1[position] - i), result);
            }
        }
        return result;
    }

    private static int getPosition(int[] a, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == a[mid]) {
                return mid;
            }
            if (target > a[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}