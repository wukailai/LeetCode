package string;

/**
 * 字符串数组最长前缀
 */

public class LongestPrefix {
    public static void main(String[] args) {
        String[] arr = new String[] {"123", "12", "1"};
        String[] arr2 = new String[] {"12", "123"};
        System.out.println(getLongestPrefix(arr));
        System.out.println(getLongestPrefix(arr2));
    }

    private static String getLongestPrefix(String[] s) {
        if (s.length == 0) {
            return "";
        }
        String result = s[0];
        for (int i = 1; i < s.length; i++) {
            while (!s[i].startsWith(result)) {
                result = result.substring(0, result.length() - 1);
                if (result.equals("")) {
                    return "";
                }
            }
        }
        return result;
    }
}