package string;

/**
 * AABB替换
 */

public class ReplaceAABB {
    public static void main(String[] args) {
        String s = "dhdiuhfuiiuuohiaabbbc";
        System.out.println(replaceAABB(s));
    }

    private static String replaceAABB(String s) {
        if (null == s || s.length() < 4) {
            return s;
        }
        String cur = s.substring(0, 3);
        String result = cur;
        for (int i = 3; i < s.length(); i++) {
            char c = s.charAt(i);
            cur = cur + c;
            if (!isAABB(cur)) {
                result += c;
                cur = cur.substring(1);
            } else {
                cur = cur.substring(0, cur.length() - 1);
            }
        }
        return result;
    }

    private static boolean isAABB(String s) {
        if (null == s || s.length() != 4) {
            return false;
        }
        return s.charAt(0) == s.charAt(1) && s.charAt(2) == s.charAt(3);
    }
}