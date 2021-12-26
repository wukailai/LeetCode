package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出合法ip
 */

public class FindLegalIP {
    private static List<List<String>> list = new ArrayList<>();

    public static void main(String[] args) {
        String s = "19216801";
        dfs(s, 0, new ArrayList<>());
        System.out.println(list);
    }

    private static void dfs(String s, int startIndex, List<String> result) {
        for (int i = 1; i <= 3; i++) {
            if (startIndex == s.length() || result.size() == 4) {
                if (startIndex == s.length() && result.size() == 4) {
                    list.add(new ArrayList<>(result));
                }
                return;
            }
            if (startIndex + i > s.length()) {
                continue;
            }
            String part = s.substring(startIndex, startIndex + i);
            if (Integer.parseInt(part) > 255) {
                continue;
            }
            if (part.startsWith("0") && part.length() != 1) {
                continue;
            }
            result.add(part);
            dfs(s, i + startIndex, result);
            result.remove(result.size() - 1);
        }
    }
}
