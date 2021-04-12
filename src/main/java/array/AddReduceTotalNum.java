package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组添加正负号使得计算之和等于目标值的次数
 */

public class AddReduceTotalNum {
    private static int count = 0;
    private static List<List<Character>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 1, 1, 1};
        int target = 1;
        calculate(arr, 0, 0, target, new ArrayList<>());
        System.out.println(count);
        System.out.println(result);
    }

    /**
     * 数组之和（可正可负）等于target
     */
    private static void calculate(int[] a, int index, int curTotal, int target, List<Character> list) {
        if (index == a.length) {
            if (curTotal == target) {
                count++;
                result.add(new ArrayList<>(list));
            }
            return;
        }
        List<Character> copyList = new ArrayList<>(list);
        list.add('+');
        calculate(a, index + 1, curTotal + a[index], target, list);
        copyList.add('-');
        calculate(a, index + 1, curTotal - a[index], target, copyList);
    }
}