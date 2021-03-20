package string;

/**
 * 在不管顺序的条件下，判断字符串是否相同
 */

public class IsSameIgnoreOrder {
    public static void main(String[] args) {
        System.out.println(isSame("adbc", "abcd"));
        System.out.println(isSame("adbc", "abbd"));
    }

    public static boolean isSame(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] index = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            index[s1.charAt(i)]++;
            index[s2.charAt(i)]--;
        }
        for (int i = 0; i < index.length; i++) {
            if (index[i] != 0) {
                return false;
            }
        }
        return true;
    }
}