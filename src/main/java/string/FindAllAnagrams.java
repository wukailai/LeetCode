package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有不考虑顺序相同字符串起始位置
 */

public class FindAllAnagrams {
    public static void main(String[] args) {
        System.out.println(find("cbcbabacd", "abc"));
    }

    private static List<Integer> find(String s, String n) {
        List<Integer> result = new ArrayList();
        if (s.length() < n.length()) {
            return result;
        }
        String cur = s.substring(0, n.length());
        int left = 0;
        int right = n.length() - 1;
        while (right < s.length()) {
            if (IsSameIgnoreOrder.isSame(n, cur)) {
                result.add(left);
            }
            // 滑动
            right++;
            if (right < s.length()) {
                cur = cur.substring(1) + s.charAt(right);
                left++;
            }
        }
        return result;
    }
}