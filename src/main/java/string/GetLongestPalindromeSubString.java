package string;

/**
 * 获取最长回文子字符串
 */

public class GetLongestPalindromeSubString {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(getSubString(s));
    }

    /**
     * 动态规划
     */
    private static String getSubString(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        String result = "";
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i + len - 1 < s.length(); i++) {
                int j = i + len - 1;
                if (len == 1) {
                    dp[i][j] = true;
                } else if (len == 2) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && len > result.length()) {
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }
}