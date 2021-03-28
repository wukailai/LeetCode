package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码组合
 */

public class PhoneNumberCombination {
    private static Map<Character, String> map = new HashMap<>();
    private static List<String> result = new ArrayList<>();

    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public static void main(String[] args) {
        String digits = "23";
        getCombination(digits, 0, new StringBuilder());
        for (String s : result) {
            System.out.print(s + " ");
        }
    }

    private static void getCombination(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        char c = digits.charAt(index);
        String s = map.get(c);
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            getCombination(digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}