package array;

/**
 * 删除有序数组中重复的元素，最终返回数组长度
 */

public class RemoveDuplicateArray {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 2, 3, 4, 4, 4, 5};
        System.out.println(remove(arr));
    }

    private static int remove(int[] a) {
        if (a.length == 0) {
            return 0;
        }
        if (a.length == 1) {
            return 1;
        }
        int count = 1;
        int index = a[0];
        for (int i = 1; i < a.length; i++) {
            if (index == a[i]) {
                continue;
            }
            index = a[i];
            count++;
        }
        return count;
    }
}