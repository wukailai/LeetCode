package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 非降序数组中，找出数组值等于数组下标的所有值
 */

public class ValueEqualToIndex2 {
    public static void main(String[] args) {
        int[] arr = new int[] {-3, -1, 0, 6, 6, 6, 7, 8, 9, 9};
        System.out.println(find(arr));
    }

    /**
     * 还有优化空间吗？
     */
    private static List<Integer> find(int[] a) {
        List<Integer> result = new ArrayList();
        int i = 0;
        while (i < a.length) {
            if (a[i] > a.length - 1) {
                break;
            }
            if (a[i] == i) {
                result.add(i);
            }
            int gap = a[i] - i;
            if (gap > 1) {
                i += gap;
            } else {
                i += 1;
            }
        }
        return result;
    }
}