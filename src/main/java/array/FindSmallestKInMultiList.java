package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 多个list中找出最小的k个数
 */

public class FindSmallestKInMultiList {
    public static void main(String[] args) {
        List<List<Integer>> listList = new ArrayList();
        List<Integer> list1 = new ArrayList();
        list1.add(2);
        list1.add(3);
        list1.add(9);
        list1.add(11);

        List<Integer> list2 = new ArrayList();
        list2.add(1);
        list2.add(4);
        list2.add(5);
        list2.add(13);

        List<Integer> list3 = new ArrayList();
        list3.add(3);
        list3.add(6);
        list3.add(7);
        list3.add(8);
        listList.add(list1);
        listList.add(list2);
        listList.add(list3);
        System.out.println(merge(listList, 7));
    }

    private static List<Integer> merge(List<List<Integer>> listList, int k) {
        List<Integer> result = new ArrayList();
        boolean isInit = false;
        for (List<Integer> list : listList) {
            for (Integer value : list) {
                if (result.size() < k) {
                    result.add(value);
                } else if (!isInit && result.size() == k) {
                    // 调整大小堆
                    for (int i = (result.size() - 1 - 1) / 2; i >= 0; i--) {
                        adjust(result, i, result.size());
                    }
                    isInit = true;
                } else {
                    if (result.get(0) > value) {
                        result.set(0, value);
                        adjust(result, 0, result.size());
                    }
                }
            }
        }
        return result;
    }

    private static void adjust(List<Integer> list, int i, int len) {
        for (int j = 2 * i + 1; j < len; j = 2 * j + 1) {
            if (j + 1 < len && list.get(j + 1) > list.get(j)) {
                j++;
            }
            if (list.get(i) > list.get(j)) {
                break;
            }
            Collections.swap(list, i, j);
            i = j;
        }
    }
}