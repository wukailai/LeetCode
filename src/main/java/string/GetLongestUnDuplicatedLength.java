package string;

import java.util.HashSet;
import java.util.Set;

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
        int end = 0;
        for (int start = 0; start < s.length(); start++) {
            if (start != 0) {
                set.remove(s.charAt(start - 1));
            }
            while (end < s.length() && !set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
            }
            result = Math.max(result, end - start);
        }
        return result;
    }
}