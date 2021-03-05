package sort;

import util.CommonUtil;
import util.GeneratorUtil;
import util.PrinterUtil;

import java.util.Stack;

/**
 * 快排
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = GeneratorUtil.newIntArray();
        PrinterUtil.printArray(arr);
        //quickSort(arr, 0, arr.length - 1);
        quickSort2(arr);
        PrinterUtil.printArray(arr);
    }

    /**
     * 递归实现
     */
    private static void quickSort(int[] a, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && a[j] >= a[start]) {
                j--;
            }
            while (i < j && a[i] <= a[start]) {
                i++;
            }
            CommonUtil.swapIntArray(a, i, j);
        }
        CommonUtil.swapIntArray(a, start, i);
        if (i - 1 > start) {
          quickSort(a, start, i - 1);
        }
        if (i + 1 < end) {
            quickSort(a, i + 1, end);
        }
    }

    /**
     * 非递归实现
     */
    private static void quickSort2(int[] a) {
        Stack<Integer> stack = new Stack();
        stack.push(0);
        stack.push(a.length - 1);
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int i = stack.pop();
            int index = getIndex(a, i, j);
            if (index - 1 > i) {
              stack.push(i);
              stack.push(index -1);
            }
            if (index + 1 < j) {
                stack.push(index + 1);
                stack.push(j);
            }
        }
    }

    private static int getIndex(int[] a, int start, int end) {
        int temp = a[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && a[j] >= temp) {
                j--;
            }
            while (i < j && a[i] <= temp) {
                i++;
            }
            CommonUtil.swapIntArray(a, i, j);
        }
        a[start] = a[i];
        a[i] = temp;
        return i;
    }
}