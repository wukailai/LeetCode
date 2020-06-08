package string;

import java.util.Stack;

/**
 * 判断是否为合法的括号
 */

public class IsValidateBracket {
    public static void main(String[] args) {
        System.out.println(isValidate("[{[()]}]"));
    }

    private static boolean isValidate(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (char c : chars) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}' || c == ']' || c == ')') {
                Character ch = stack.pop();
                if (null == ch) {
                    return false;
                }
                if (c == '}' && ch != '{') {
                    return false;
                }
                if (c == ']' && ch != '[') {
                    return false;
                }
                if (c == ')' && ch != '(') {
                    return false;
                }
            }
        }
        return true;
    }
}