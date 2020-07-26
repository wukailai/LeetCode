package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找出所有子集
 */

public class FindAllSubSets {
    private static List<List<Integer>> result = new ArrayList();
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 2};
        Arrays.sort(arr);
        findAllSubSets(arr, 0, new ArrayList());
        System.out.println(result);
    }

    private static void findAllSubSets(int[] a, int index, List<Integer> trace) {
        result.add(new ArrayList(trace));
        for (int i = index; i < a.length; i++) {
            if (i > index && a[i - 1] == a[i]) {
                continue;
            }
            trace.add(a[i]);
            findAllSubSets(a, i + 1, trace);
            trace.remove(trace.size() - 1);
        }
    }
}