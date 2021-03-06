package string;

import java.util.HashSet;
import java.util.Set;

/**
 * 获取最长不重复子字符串
 */

public class GetLongestUnDuplicatedLength {
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "ppwikej";
        System.out.println(getMaxLen(s1));
        System.out.println(getMaxLen(s2));
        System.out.println(getMaxLen(s3));
        System.out.println(getMaxLen(s4));
    }

    /**
     * 使用滑动窗口
     */
    private static int getMaxLen(String s) {
        int result = 0;
        Set<Character> set = new HashSet();
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            while (end < s.length() && !set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                result = Math.max(result, end - start + 1);
                end++;
            }
            set.remove(s.charAt(start));
            start++;
        }
        return result;
    }

    /**
     * 滑动窗口-更容易理解
     */
    private static String getUnDuplicatedSubString(String s) {
        String result = "";
        String cur = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cur.indexOf(c) == -1) {
                cur = cur + c;
                if (result.length() < cur.length()) {
                    result = cur;
                }
            } else {
                cur = cur.substring(1);
            }
        }
        return result;
    }
}