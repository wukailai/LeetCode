package string;

/**
 * 是否为旋转字符串对
 */

public class IsRotateStringPair {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "cdab";
        System.out.println(isRotateStringPair(s1, s2));
        System.out.println(isRotateStringPair2(s1, s2));
    }

    private static boolean isRotateStringPair(String s1, String s2) {
        if (null == s1 && null == s2) {
            return true;
        }
        if (null == s1 || null == s2) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        return (s2 + s2).contains(s1);
    }

    private static boolean isRotateStringPair2(String s1, String s2) {
        if (null == s1 && null == s2) {
            return true;
        }
        if (null == s1 || null == s2) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        int len = s1.length();
        for (int i = 1; i <= len; i++) {
            String temp = s1.substring(i) + s1.substring(0, i);
            if (temp.equals(s2)) {
                return true;
            }
        }
        return false;
    }
}