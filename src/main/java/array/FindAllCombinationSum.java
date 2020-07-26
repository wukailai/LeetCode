package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找出数组之和为target的所有组合
 */

public class FindAllCombinationSum {
    private static List<List<Integer>> result = new ArrayList();

    public static void main(String[] args) {
        int[] arr = new int[] {2, 5, 2, 1, 2};
        Arrays.sort(arr);
        int target = 5;
        findCombinations(arr, 0, target, new ArrayList());
        System.out.println(result);
    }

    private static void findCombinations(int[] candidates, int index, int target, List<Integer> trace) {
        if (target == 0) {
            result.add(new ArrayList(trace));
            return;
        }
        if (target > 0) {
            for (int i = index; i < candidates.length; i++) {
                if (i > index && candidates[i - 1] == candidates[i]) {
                    continue;
                }
                //作出选择
                trace.add(candidates[i]);
                findCombinations(candidates, i + 1, target - candidates[i], trace);
                //撤销选择
                trace.remove(trace.size() - 1);
            }
        }
    }
}