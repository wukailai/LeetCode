package search;

import util.GeneratorUtil;
import util.PrinterUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两数相加之和
 */

public class TwoNumSumSearch {
    public static void main(String[] args) {
        int[] arr = GeneratorUtil.newIntArray();
        PrinterUtil.printArray(arr);
        PrinterUtil.printArray(getIndex(arr, 10));
        PrinterUtil.printArray(getIndex2(arr, 10));
        List<int[]> list = getIndexList(arr, 7);
        System.out.println("====================");
        for (int[] i : list) {
            System.out.println(Arrays.toString(i));
        }
    }

    private static int[] getIndex(int[] a, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(target - a[i])) {
                return new int[] {i, map.get(target - a[i])};
            }
            map.put(a[i], i);
        }
        return new int[] {-1, -1};
    }

    private static int[] getIndex2(int[] a, int target) {
        Arrays.sort(a);
        int start = 0;
        int end = a.length - 1;
        while (start < end) {
            if (a[start] + a[end] == target) {
                return new int[] {start, end};
            }
            while (start <= end && a[start] + a[end] > target) {
                end--;
            }
            while (start <= end && a[start] + a[end] < target) {
                start++;
            }
        }
        return new int[] {-1, -1};
    }

    /**
     * 找出所有组合下标
     */
    private static List<int[]> getIndexList(int[] a, int target) {
        Arrays.sort(a);
        List<int[]> list = new ArrayList();
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            if (a[start] + a[end] == target) {
                list.add(new int[] {start, end});
                //两个while处理连续相同数的情况
                while (start + 1 <= end && a[start] == a[start + 1]) {
                    list.add(new int[] {start + 1, end});
                    start++;
                }
                while (start <= end - 1 && a[end] == a[end - 1]) {
                    list.add(new int[] {start, end - 1});
                    end--;
                }
                start++;
                end--;
            }
            while (start <= end && a[start] + a[end] > target) {
                end--;
            }
            while (start <= end && a[start] + a[end] < target) {
                start++;
            }
        }
        return list;
    }
}