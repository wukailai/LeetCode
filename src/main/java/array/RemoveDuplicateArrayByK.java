package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 删除连续重复数超过K的元素
 */

public class RemoveDuplicateArrayByK {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 2, 2, 2, 2, 3, 4, 4, 4, 5, 5, 5};
        int k = 3;
        List<Integer> list = remove(arr, k);
        System.out.println(list);
    }

    private static List<Integer> remove(int[] a, int k) {
        List<Integer> list = new ArrayList<>();
        if (null == a || a.length == 0) {
           return list;
        }
        if (a.length == 1) {
            list.add(a[0]);
            return list;
        }
        int index = a[0];
        int duplicateNum = 1;
        list.add(a[0]);
        for (int i = 1; i < a.length; i++) {
            if (index == a[i]) {
                duplicateNum++;
                if (duplicateNum > k) {
                    continue;
                } else {
                    list.add(a[i]);
                }
            } else {
                index = a[i];
                duplicateNum = 1;
                list.add(a[i]);
            }
        }
        return list;
    }
}