package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 产生括号
 */

public class GenerateParentheses {
    private static List<String> result = new ArrayList();
    private static String[] arr = new String[] {"(", ")"};
    public static void main(String[] args) {
//        generate(2, "");
//        generate(2, new StringBuilder());
        generate(2, "", 0, 0);
        for (String s : result) {
            System.out.print(s + " ");
        }
    }

    /**
     * 产生所有组合
     */
    private static void generate(int n, String s) {
        if (s.length() == 2 * n) {
            result.add(s);
            return;
        }
        // String这里不需要回溯，因为即使将s + "("传给s，s指向的字符串也是不变的
        generate(n, s + "(");
        generate(n, s + ")");
    }

    /**
     * 产生所有组合，StringBuilder代替String实现
     */
    private static void generate(int n, StringBuilder sb) {
        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }
        for (String s : arr) {
            sb.append(s);
            generate(n, sb);
            // StringBuilder这里需要回溯，因为StringBuilder指向的是对象
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /**
     * 产生所有合法组合
     */
    private static void generate(int n, String s, int left, int right) {
        if (left > n || right > left) {
            return;
        }
        if (s.length() == 2 * n) {
            result.add(s);
            return;
        }
        generate(n, s + "(", left + 1, right);
        generate(n, s + ")", left, right + 1);
    }
}