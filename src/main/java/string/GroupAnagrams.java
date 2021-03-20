package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 忽略顺序相同的字符串分组
 */

public class GroupAnagrams {
    public static void main(String[] args) {
        List<String> strList = new ArrayList();
        strList.add("eat");
        strList.add("tea");
        strList.add("tan");
        strList.add("ate");
        strList.add("nat");
        strList.add("bat");
        System.out.println(find(strList));
    }

    private static List<List<String>> find(List<String> strList) {
        List<List<String>> result = new ArrayList();
        for (String str : strList) {
            boolean isUnique = true;
            for (List<String> list : result) {
                if (isSame(list.get(0), str)) {
                    isUnique = false;
                    list.add(str);
                    break;
                }
            }
            if (isUnique) {
                List<String> newList = new ArrayList();
                newList.add(str);
                result.add(newList);
            }
        }
        return result;
    }

    private static boolean isSame(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] index = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            index[s1.charAt(i)]++;
            index[s2.charAt(i)]--;
        }
        for (int i = 0; i < index.length; i++) {
            if (index[i] != 0) {
                return false;
            }
        }
        return true;
    }
}