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
        findAllPermutations(0, Arrays.asList(arr));
//        dfs(arr, 0, new boolean[arr.length], new ArrayList<>());
        System.out.println(result);
    }

    private static void findAllPermutations(int index, List<Integer> trace) {
        if (index == trace.size()) {
            result.add(new ArrayList(trace));
            return;
        }
        for (int i = index; i < trace.size(); i++) {
            //维护动态数组
            Collections.swap(trace, i , index);
            findAllPermutations(index + 1, trace);
            //撤销操作
            Collections.swap(trace, i , index);
        }
    }

    private static void dfs(Integer[] a, int level, boolean[] isUsed, List<Integer> res) {
        if (level == a.length) {
            result.add(new ArrayList<>(res));
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (isUsed[i]) {
                continue;
            }
            isUsed[i] = true;
            res.add(a[i]);
            dfs(a, level + 1, isUsed, res);
            isUsed[i] = false;
            res.add(res.size() - 1);
        }
    }
}