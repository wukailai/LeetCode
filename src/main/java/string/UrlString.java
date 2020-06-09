package string;

/**
 * url化字符串（指定长度，后缀可能有多个空格），用20%替换空格
 */

public class UrlString {
    public static void main(String[] args) {
        System.out.println(getUrl("a b c  def   ", 10));
    }
    private static String getUrl(String s, int len) {
        return s.substring(0, len).replaceAll(" ", "20%");
    }
}