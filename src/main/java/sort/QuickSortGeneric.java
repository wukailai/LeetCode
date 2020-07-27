package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 快排-范型实现
 */

public class QuickSortGeneric {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(3);
        list.add(1);
        list.add(2);
        quickSort(list, 0, list.size() - 1);
        System.out.println(list);
    }

    private static <T extends Comparable> void quickSort(List<T> list, int start, int end) {
        T temp = list.get(0);
        int i = start;
        int j = end;
        while (i < j) {
            while (isBiggerAndEqual(list.get(j), temp) && i < j) {
                j--;
            }
            while (isBiggerAndEqual(temp, list.get(i)) && i < j) {
                i++;
            }
            Collections.swap(list, i, j);
        }
        list.set(start, list.get(i));
        list.set(i, temp);
        if (i - 1 > start) {
          quickSort(list, start, i - 1);
        }
        if (i + 1 < end) {
            quickSort(list, i + 1, end);
        }
    }

    public static <T extends Comparable> boolean isBiggerAndEqual(T a, T b) {
        return a.compareTo(b) >= 0;
    }
}