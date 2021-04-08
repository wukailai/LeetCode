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
}