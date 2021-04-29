package string;

import java.util.Stack;

/**
 * 字符串计算
 */

public class ExpressionCompute {
    public static void main(String[] args) {
        String s = "(1+(14+5+2)-3)+(6+8)";
        System.out.println(compute(s));
    }

    private static int compute(String s) {
        int result = 0;
        int num = 0;
        // 乘法实现加减法
        int sign = 1;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            } else if (c >= '0' && c <= '9') {
                // 考虑连续多位数字的情况
                num = 10 * num + Integer.parseInt(c + "");
                if (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    continue;
                }
            } else if (c == '+') {
                // num置为0是为了保证+不对计算结果产生影响
                num = 0;
                sign = 1;
            } else if (c == '-') {
                // num置为0是为了保证-不对计算结果产生影响
                num = 0;
                sign = -1;
            } else if (c == '(') { // 遇到(保存现场
                stack.push(result);
                stack.push(sign);
                // 三个参数同时初始化
                result = 0;
                num = 0;
                sign = 1;
            } else if (c == ')') { // 遇到)恢复现场
                num = result;
                sign = stack.pop();
                result = stack.pop();
            }
            result += num * sign;
        }
        return result;
    }
}