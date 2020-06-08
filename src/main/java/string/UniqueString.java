package string;

/**
 * 判断字符串是否重复
 */

public class UniqueString {
    public static void main(String[] args) {
        System.out.println(isUnique("2463846363"));
        System.out.println(isUnique("1234567890"));
    }

    private static boolean isUnique(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.lastIndexOf(s.charAt(i)) != i) {
                return false;
            }
        }
        return true;
    }
}