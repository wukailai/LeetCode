package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出1-n中所有消失的数字
 */

public class FindDisappearNumber {
    public static void main(String[] args) {
        int[] arr = new int[] {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(find(arr));
    }

    private static List<Integer> find(int[] a) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            int index = Math.abs(a[i]) - 1;
            if (a[index] > 0) {
                a[index] = -a[index];
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
               list.add(i + 1);
            }
        }
        return list;
    }
}