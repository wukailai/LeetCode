package string;

import java.util.ArrayList;
import java.util.List;

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
        boolean isInit = false;
        String cur = "" + s.charAt(left);
        for (int right = 1; right < s.length(); right++) {
           if (!isInit) {
               while (right - left + 1 != n.length()) {
                    cur += s.charAt(right);
                    right++;
                }
               cur += s.charAt(right);
                isInit = true;
            } else {
                cur = cur.substring(1) + s.charAt(right);
                left++;
            }
            if (IsSameIgnoreOrder.isSame(n, cur)) {
                result.add(left);
            }
        }
        return result;
    }
}