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
        for (int j = 2 * i + 1; j < len; j = 2 * j + 1) {
            if (j + 1 < len && a[j + 1] > a[j]) {
                j++;
            }
            if (a[i] >= a[j]) {
                break;
            }
            CommonUtil.swapIntArray(a, i, j);
            i = j;
        }
     }

     private static void heapSort(int[] a) {
        // 从第一个非叶子节点开始构建大顶推
        for (int i = (a.length - 1 - 1) / 2; i >= 0; i--) {
            adjustHeap(a, i, a.length);
        }
        for (int i = a.length - 1; i >= 0; i--) {
            //只调整0位置即可
            CommonUtil.swapIntArray(a, 0, i);
            adjustHeap(a, 0, i);
        }
     }
}