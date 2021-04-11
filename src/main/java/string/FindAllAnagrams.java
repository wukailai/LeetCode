package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有不考虑顺序相同字符串起始位置
 */

public class FindAllAnagrams {
    public static void main(String[] args) {
        System.out.println(find("cbaebabacd", "abc"));
    }

    private static List<Integer> find(String s, String n) {
        List<Integer> result = new ArrayList();
        if (s.length() < n.length()) {
            return result;
        }
        int left = 0;
        int right = 0;
        boolean isInit = false;
        String cur = "";
        while (right < s.length()) {
           if (!isInit) {
               while (right - left + 1 < n.length()) {
                   cur += s.charAt(right);
                   right++;
               }
               cur += s.charAt(right);
               isInit = true;
            } else {
               left++;
               right++;
               if (right < s.length()) {
                   cur = cur.substring(1) + s.charAt(right);
               }
            }
            if (IsSameIgnoreOrder.isSame(n, cur)) {
                result.add(left);
            }
        }
        return result;
    }
}