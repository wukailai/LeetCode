package search;

import util.GeneratorUtil;
import util.PrinterUtil;

/**
 * 二分法查找
 */

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = GeneratorUtil.newSortedIntArray();
        PrinterUtil.printArray(arr);
        System.out.println(search(arr, 0, arr.length - 1, 5));
        System.out.println(search2(arr, 5));
    }

    /**
     * 递归实现
     */
    private static int search(int[] a, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = (end - start) / 2 + start;
        if (a[mid] == target) {
            return mid;
        } else if (a[mid] > target) {
            return search(a, start, mid - 1, target);
        } else {
            return search(a, mid + 1, end, target);
        }
    }

    /**
     * 非递归实现
     */
    private static int search2(int[] a, int target) {
        int start = 0;
        int end = a.length - 1;
        int mid;
        while (end >= start) {
            mid = (end - start) / 2 + start;
            if (a[mid] == target) {
                return mid;
            } else if(a[mid] > target) {
                end = mid - 1;
            } else if (a[mid] < target) {
                start = mid + 1;
            }
        }
        return -1;
    }
}