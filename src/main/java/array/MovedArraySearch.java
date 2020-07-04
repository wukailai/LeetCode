package array;

/**
 * 经过一次旋转排序后的数组搜索
 * 要求时间复杂度O（logN）
 */

public class MovedArraySearch {
    public static void main(String[] args) {
        int[] arr = new int[] {5, 6, 7, 8, 1, 2, 3, 4};
        System.out.println(search(arr, 3));
    }

    private static int search(int[] a, int target) {
        int start = 0;
        int end = a.length - 1;
        while (end >= start) {
            int mid = (start + end) / 2;
            if (a[mid] == target) {
                return mid;
            }
            if (a[start] <= a[mid]) {
                if (target >= a[start] && target < a[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > a[mid] && target <= a[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;
    }
}