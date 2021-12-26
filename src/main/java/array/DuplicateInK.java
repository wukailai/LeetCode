package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wukailai
 * @date 2020/07/05 17:44
 * @description K间距是否有重复元素
 */

public class DuplicateInK {
    public static void main(String[] args) {
        int[] arr = new int[] {1 ,2, 3, 1};
        System.out.println(hasSame(arr, 2));
        System.out.println(hasSame(arr, 3));
        System.out.println(hasSame2(arr, 3));
        System.out.println(hasSame2(arr, 4));
    }

    /**
     * 类似于滑动窗口实现
     */
    private static boolean hasSame(int[] a, int k) {
        Set<Integer> set = new HashSet();
        for (int i = 0; i < a.length; i++) {
            if (!set.add(a[i])) {
                return true;
            }
            if (set.size() > k) {
                set.remove(a[i - k]);
            }
        }
        return false;
    }

    /**
     * 连续k个数中是否有相同元素，标准滑动敞口实现
     */
    private static boolean hasSame2(int[] a, int k) {
        Set<Integer> set = new HashSet<>();
        int start = 0;
        int end = 0;
        while (end < a.length) {
            if (!set.add(a[end])) {
                return true;
            }
            if (end - start + 1 == k) {
                set.remove(a[end - k + 1]);
                start++;
            }
            end++;
        }
        return false;
    }
}