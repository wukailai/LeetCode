package string;

import java.util.HashSet;
import java.util.Set;

/**
 * 不考虑顺序的情况下判断字符串是为回文排列串
 */

public class IsPalindromeIgnoreOrder {
    public static void main(String[] args) {
        System.out.println(isPalindromeIgnoreOrder("abcdcbe"));
        System.out.println(isPalindromeIgnoreOrder("abcdcba"));
    }

    private static boolean isPalindromeIgnoreOrder(String s) {
        Set<Character> set = new HashSet();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                set.remove(c);
            }
        }
        return set.size() <= 1;
    }
}