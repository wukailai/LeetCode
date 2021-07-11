package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 按列收集元素
 */

public class GatherByColumn {
    public static void main(String[] args) {
        List<List<Integer>> listList = new ArrayList();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);
        List<Integer> list3 = new ArrayList<>();
        list3.add(8);
        List<Integer> list4 = new ArrayList<>();
        list4.add(9);
        list4.add(10);
        listList.add(list1);
        listList.add(list2);
        listList.add(list3);
        listList.add(list4);
        List<Integer> result = gather(listList);
        System.out.println(result);
    }

    private static List<Integer> gather(List<List<Integer>> listList) {
        List<Integer> result = new ArrayList<>();
        int[] sizeArr = new int[listList.size()];
        int maxSize = Integer.MIN_VALUE;
        for (int i = 0; i < listList.size(); i++) {
            List<Integer> list = listList.get(i);
            int size = list.size();
            sizeArr[i] = size;
            maxSize = Math.max(maxSize, size);
        }
        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < listList.size(); j++) {
                List<Integer> list = listList.get(j);
                int size = sizeArr[j];
                if (i >= size) {
                    continue;
                }
                result.add(list.get(i));
            }
        }
        return result;
    }
}