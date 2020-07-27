package array;

/**
 * 升序数组中，找出数组值等于数组下标的那个值
 */

public class ValueEqualToIndex {
    public static void main(String[] args) {
        int[] arr = new int[] {-3, -1, 0, 3, 5};
        System.out.println(find(arr));
    }

    private static int find(int[] a) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] == mid) {
                return mid;
            }
            if (a[mid] > mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}