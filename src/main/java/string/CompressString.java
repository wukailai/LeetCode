package string;

/**
 * 字符串压缩
 */

public class CompressString {
    public static void main(String[] args) {
        System.out.println(compressString("aaaacffcvbb"));
        System.out.println(compressString("a"));
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
                sb.append(num);
                cur = c;
                num = 1;
            } else {
                num++;
            }
        }
        sb.append(cur);
        sb.append(num);
        return sb.toString();
    }
}