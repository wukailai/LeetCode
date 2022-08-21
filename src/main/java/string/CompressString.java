package string;

/**
 * 字符串压缩
 */

public class CompressString {
    public static void main(String[] args) {
        System.out.println(compressString("aaaacffcvbb"));
        System.out.println(compressString("a"));
        System.out.println(uncompressString("a4cf2cvb2h6"));
    }

    private static String compressString(String s) {
        if (null == s || "".equals(s)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        char cur = s.charAt(0);
        int num = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != cur) {
                sb.append(cur);
                if (num > 1) {
                    sb.append(num);
                }
                cur = c;
                num = 1;
            } else {
                num++;
            }
        }
        sb.append(cur);
        if (num > 1) {
            sb.append(num);
        }
        return sb.toString();
    }

    private static String uncompressString(String s) {
        if (null == s || s.length() < 2) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = start + 1;
        while (end < s.length()) {
            char startCharacter = s.charAt(start);
            char endCharacter = s.charAt(end);
            int number = 1;
            if (isNumber(endCharacter)) {
                String numberStr = "";
                while (isNumber(endCharacter)) {
                    numberStr += endCharacter;
                    if (end++ == s.length() - 1) {
                        break;
                    }
                    endCharacter = s.charAt(end);
                }
                number = Integer.parseInt(numberStr);
            }
            int j = 0;
            while (j++ < number) {
                sb.append(startCharacter);
            }
            start = end;
            end = start + 1;
        }
        if (start ==  s.length() - 1) {
            sb.append(s.charAt(start));
        }
        return sb.toString();
    }

    private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}