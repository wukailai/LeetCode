package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组添加正负号使得计算之和等于目标值的次数
 */

public class AddReduceTotalNum {
    private static int count = 0;
    private static List<List<Character>> listResult = new ArrayList<>();
    private static List<String> strResult = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 1, 1, 1};
        int target = 1;
        calculate(arr, 0, 0, target);
        calculate2(arr, 0, 0, target, new ArrayList<>());
        calculate3(arr, 0, 0, target, "");
        System.out.println(count);
        System.out.println(listResult);
        System.out.println(strResult);
    }

    /**
     * 求出总次数
     */
    private static void calculate(int[] a, int index, int curTotal, int target) {
        if (index == a.length) {
            if (curTotal == target) {
                count++;
            }
            return;
        }
        calculate(a, index + 1, curTotal + a[index], target);
        calculate(a, index + 1, curTotal - a[index], target);
    }

    /**
     * 求出所有组合
     */
    private static void calculate2(int[] a, int index, int curTotal, int target, List<Character> list) {
        if (index == a.length) {
            if (curTotal == target) {
                listResult.add(new ArrayList<>(list));
            }
            return;
        }
        List<Character> copyList = new ArrayList<>(list);
        list.add('+');
        calculate2(a, index + 1, curTotal + a[index], target, list);
        copyList.add('-');
        calculate2(a, index + 1, curTotal - a[index], target, copyList);
    }

    /**
     * 求出所有组合
     */
    private static void calculate3(int[] a, int index, int curTotal, int target, String s) {
        if (index == a.length) {
            if (curTotal == target) {
                strResult.add(s);
            }
            return;
        }
        calculate3(a, index + 1, curTotal + a[index], target, s + '+');
        calculate3(a, index + 1, curTotal - a[index], target, s + '-');
    }
}