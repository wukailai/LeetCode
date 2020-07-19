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
        findAllSubSets(0, arr, new ArrayList());
        System.out.println(result);
    }

    private static void findAllSubSets(int index, int[] a, List<Integer> trace) {
        result.add(new ArrayList(trace));
        for (int j = index; j < a.length; j++) {
            if (j > index && a[j - 1] == a[j]) {
                continue;
            }
            trace.add(a[j]);
            findAllSubSets(j + 1, a, trace);
            trace.remove(trace.size() - 1);
        }
    }
}