package array;

import util.PrinterUtil;

/**
 * 原地删除数组中的元素，返回最终数组大小
 */

public class RemoveAppointArray {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 3 ,2, 4, 5, 2, 6};
        System.out.println(remove(arr, 2));
        PrinterUtil.printArray(arr);
    }

    private static int remove(int[] a, int target) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != target) {
                int temp = a[i];
                a[i] = a[count];
                a[count] = temp;
                count++;
            }
        }
        return count;
    }
}