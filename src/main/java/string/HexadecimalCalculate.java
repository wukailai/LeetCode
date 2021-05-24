package string;

/**
 * 16进制字符串运算
 */

public class HexadecimalCalculate {
    private static int CARRY = 36;
    public static void main(String[] args) {
        String s1 = "1bb";
        String s2 = "2x";
        String s = calculate(s1, s2);
        System.out.println(s);
    }

    private static String calculate(String s1, String s2) {
        if (null == s1) {
            return s2;
        }
        if (null == s2) {
            return s1;
        }
        String result = "";
        int end1 = s1.length() - 1;
        int end2 = s2.length() - 1;
        int carry = 0;
        while (end1 >= 0 || end2 >= 0) {
            char c1 = end1 >= 0 ? s1.charAt(end1--) : '0';
            char c2 = end2 >= 0 ? s2.charAt(end2--) : '0';
            int value1 = hex2Dec(c1);
            int value2 = hex2Dec(c2);
            int remain = (value1 + value2 + carry) % CARRY;
            carry = (value1 + value2 + carry) / CARRY;
            result = dec2Hex(remain) + result;
        }
        if (carry > 0) {
            result = carry + result;
        }
        return result;
    }

    private static int hex2Dec(char c) {
        if (c >= '0' && c <= '9') {
            return Integer.parseInt(c + "");
        } else {
            return 10 + (c - 'a');
        }
    }

    private static char dec2Hex(int i) {
        if (i >= 0 && i <= 9) {
           return (char) (i + 48);
        } else {
            return (char) ('a' + i - 10);
        }
    }
}