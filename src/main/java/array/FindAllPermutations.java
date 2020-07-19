package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 找出没有重复数组全排列结果
 */

public class FindAllPermutations {
    private static List<List<Integer>> result = new ArrayList();

    public static void main(String[] args) {
        Integer[] arr = new Integer[] {1, 2, 3, 4};
        findAllPermutations(arr.length, Arrays.asList(arr), 0);
        System.out.println(result);
    }

    private static void findAllPermutations(int len, List<Integer> trace, int first) {
        if (first == len) {
            result.add(new ArrayList(trace));
            return;
        }
        for (int i = first; i < len; i++) {
            //维护动态数组
            Collections.swap(trace, i , first);
            findAllPermutations(len, trace, first + 1);
            //撤销操作
            Collections.swap(trace, i , first);
        }
    }
}