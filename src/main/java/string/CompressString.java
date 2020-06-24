package string;

/**
 * 字符串压缩
 */

public class CompressString {
    public static void main(String[] args) {
        System.out.println(compressString("aaaacffcvbb"));
    }

    private static String compressString(String s) {
        StringBuilder sb = new StringBuilder();
        Character last = null;
        int num = 1;
        for (char c : s.toCharArray()) {
            if (null == last) {
                last = c;
            } else if (c != last) {
                sb.append(last);
                sb.append(num);
                last = c;
                num = 1;
            } else {
                num++;
            }
        }
        return sb.toString();
    }
}