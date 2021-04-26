package string;

/**
 * 小数点字符串相加
 */

public class DecimalStringPlus {
    public static void main(String[] args) {
        String s1 = "1234.778";
        String s2 = "783787.23456";
        System.out.println(twoStringPlus(s1, s2));
    }

    private static String twoStringPlus(String s1, String s2) {
        String result = "";
        int index1 = s1.indexOf(".");
        int index2 = s2.indexOf(".");
        int decimalFrom1 = index1 + 1;
        int decimalTo1 = s1.length() - 1;
        int decimalFrom2 = index2 + 1;
        int decimalTo2 = s2.length() - 1;
        while (decimalTo1 - decimalFrom1 > decimalTo2 - decimalFrom2) {
            result = s1.charAt(decimalTo1--) + result;
        }
        while (decimalTo2 - decimalFrom2 > decimalTo1 - decimalFrom1) {
            result = s2.charAt(decimalTo2--) + result;
        }
        int carry = 0;
        while (decimalTo1 >= decimalFrom1) {
            int value1 = Integer.parseInt(s1.charAt(decimalTo1--) + "");
            int value2 = Integer.parseInt(s2.charAt(decimalTo2--) + "");
            int remain = (value1 + value2 + carry) % 10;
            carry = (value1 + value2 + carry) / 10;
            result = remain + result;
        }
        result = "." + result;
        int intTo1 = index1 - 1;
        int intTo2 = index2 - 1;
        while (intTo1 >= 0 || intTo2 >= 0) {
            int value1 = intTo1 < 0 ? 0 : Integer.parseInt(s1.charAt(intTo1--) + "");
            int value2 = intTo2 < 0 ? 0 : Integer.parseInt(s2.charAt(intTo2--) + "");
            int remain = (value1 + value2 + carry) % 10;
            carry = (value1 + value2 + carry) / 10;
            result = remain + result;
        }
        if (carry > 0) {
            result = carry + result;
        }
        return result;
    }
}