package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 单词分拆
 */

public class WordBreak {
    public static void main(String[] args) {
        String s1 = "leetcode";
        List<String> list1 = new ArrayList<>();
        list1.add("leet");
        list1.add("code");
        System.out.println(isLegal(s1, list1));
        String s2 = "applepenapple";
        List<String> list2 = new ArrayList<>();
        list2.add("apple");
        list2.add("pen");
        System.out.println(isLegal(s2, list2));
        String s3 = "catsandog";
        List<String> list3 = new ArrayList<>();
        list3.add("cats");
        list3.add("dog");
        list3.add("sand");
        list3.add("and");
        list3.add("cat");
        System.out.println(isLegal(s3, list3));
    }

    private static boolean isLegal(String s, List<String> list)  {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[j] && list.contains(s.substring(j, i));
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}