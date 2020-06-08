package sort;

import util.CommonUtil;
import util.GeneratorUtil;
import util.PrinterUtil;

/**
 *  堆排序
 */

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = GeneratorUtil.newIntArray();
        PrinterUtil.printArray(arr);
        heapSort(arr);
        PrinterUtil.printArray(arr);
    }

     private static void adjustHeap(int[] a, int i, int len) {
        int temp = a[i];
        for (int j = 2 * i; j < len; j = 2 * j) {
            if (a[j + 1] > a[j]) {
                j++;
            }
            if (temp >= a[j]) {
                break;
            }
            a[i] = a[j];
            i = j;
        }
        a[i] = temp;
     }

     private static void heapSort(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            adjustHeap(a, i, a.length - 1);
        }
        for (int i = a.length - 1; i >= 0; i--) {
            CommonUtil.swapIntArray(a, 0, i);
            adjustHeap(a, 0, i - 1);
        }
     }
}