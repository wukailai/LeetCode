package string;

import java.util.Stack;

/**
 * 解码字符串
 */

public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a2[bc]]";
        System.out.println(decode(s));
    }

    private static String decode(String s) {
        String result = "";
        int multiply = 0;
        Stack<Integer> numStack = new Stack();
        Stack<String> stringStack = new Stack();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                // 连续两个数字组成多位数的情况
                multiply = multiply * 10 + Integer.parseInt("" + chars[i]);
            } else if (chars[i] == '[') {
                numStack.push(multiply);
                stringStack.push(result);
                // 两个参数同时初始化
                result = "";
                multiply = 0;
            } else if (chars[i] == ']') {
                String temp = "";
                int n = numStack.pop();
                while (n > 0) {
                    temp += result;
                    n--;
                }
                result = stringStack.pop() + temp;
            } else {
                result += chars[i];
            }
        }
        return result;
    }
}