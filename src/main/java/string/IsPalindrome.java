package string;

/**
 * 判断字符串是否为回文字符串
 */

public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("12321"));
        System.out.println(isPalindrome("123456"));
        System.out.println(isPalindrome2("12321"));
        System.out.println(isPalindrome2("123456"));
    }

    private static boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    private static boolean isPalindrome2(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}