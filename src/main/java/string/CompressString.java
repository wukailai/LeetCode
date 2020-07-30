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
        Character index = null;
        int num = 1;
        for (char c : s.toCharArray()) {
            if (null == index) {
                index = c;
            } else if (c != index) {
                sb.append(index);
                sb.append(num);
                index = c;
                num = 1;
            } else {
                num++;
            }
        }
        sb.append(index);
        sb.append(num);
        return sb.toString();
    }
}