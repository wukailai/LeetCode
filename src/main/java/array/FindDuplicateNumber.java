package array;

/**
 * 长度为n+1的数组中包含1-n之间的元素，找出唯一重复的那个数字
 */

public class FindDuplicateNumber {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 4, 2, 2};
        int[] arr1 = new int[] {4, 1, 3, 3, 2};
        int[] arr2 = new int[] {1, 1};
        System.out.println(find(arr));
        System.out.println(find(arr1));
        System.out.println(find(arr2));
    }

    private static int find(int[] a) {
        int start = 0;
        int end = a.length - 1;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            int count = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= mid) {
                    count++;
                }
            }
            // 说明重复的值一定在1~mid之间
            if (count > mid) {
                // 这里end = mid，所以while条件一定是小于，不能是小于等于，否则会出现死循环
                end = mid;
            } else { // 这里其实只有count == mid这一种情况
                start = mid + 1;
            }
        }
        return start;
    }
}