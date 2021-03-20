package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 宝石与石头
 */

public class JewelsAndStones {
    public static void main(String[] args) {
        System.out.println(count("aA", "aAAbbbb"));
        System.out.println(count2("aA", "aAAbbbb"));
        System.out.println(count3("aA", "aAAbbbb"));
    }

    private static int count(String j, String s) {
        int count = 0;
        Set<Character> set = new HashSet();
        for (Character c : j.toCharArray()) {
            set.add(c);
        }
        for (Character c : s.toCharArray()) {
            if (set.contains(c)) {
                count++;
            }
        }
        return count;
    }

    private static int count2(String j, String s) {
        int count = 0;
        for (Character c : s.toCharArray()) {
            if (j.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    private static int count3(String j, String s) {
        int count = 0;
        for (Character c1 : j.toCharArray()) {
            for (Character c2 : s.toCharArray()) {
                if (c1 == c2) {
                   count++;
                }
            }
        }
        return count;
    }
}