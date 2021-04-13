package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 */

public class Combination {
    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        List<List<Integer>> listList = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        List<Integer> list3 = new ArrayList<>();
        list3.add(7);
        list3.add(8);
        list3.add(9);
        listList.add(list1);
        listList.add(list2);
        listList.add(list3);
        getCombination(listList, 0, new StringBuilder());
        System.out.println(result);
    }

    private static void getCombination(List<List<Integer>> listList, int index, StringBuilder sb) {
        if (index == listList.size()) {
            result.add(sb.toString());
            return;
        }
        List<Integer> list = listList.get(index);
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            getCombination(listList, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}