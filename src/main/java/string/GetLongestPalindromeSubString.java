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
                    dp[i][j] = s.charAt(i) == s.charAt(j);
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

    /**
     * 动态规划2，更容易理解
     */
    private static String getSubString2(String s) {
        String result = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int len = 1; len <= s.length(); len++) {
            for (int start = 0; start < s.length(); start++) {
                int end = start + len - 1;
                if (end > s.length() - 1) {
                    break;
                }
                if (len == 1 || (s.charAt(start) == s.charAt(end) && dp[start + 1][end - 1])) {
                    dp[start][end] = true;
                }
                if (dp[start][end] && end - start + 1 > result.length()) {
                    result = s.substring(start, end + 1);
                }
            }
        }
        return result;
    }
}