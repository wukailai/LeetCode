package array;

/**
 * 长度为n+1的数组中包含1-n之间的元素，找出唯一重复的那个数字
 */

public class FindDuplicateNumber {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 4, 2, 2};
        int[] arr1 = new int[] {4, 1, 3, 3, 2};
        System.out.println(find(arr));
        System.out.println(find(arr1));
    }

    private static int find(int[] a) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int count = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}