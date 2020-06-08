package search;

import util.GeneratorUtil;
import util.PrinterUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数相加之和
 */

public class TwoNumSumSearch {
    public static void main(String[] args) {
        int[] arr = GeneratorUtil.newIntArray();
        PrinterUtil.printArray(arr);
        PrinterUtil.printArray(getIndex(arr, 12));
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
}