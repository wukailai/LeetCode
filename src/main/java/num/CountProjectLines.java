package num;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * 计算项目下面java文件代码总行数
 */

public class CountProjectLines {
    private static int num = 0;

    public static void main(String[] args) throws Exception {
        String path = "/Users/wukailai/MyProject/idea/work/deploy-init";
        File file = new File(path);
        getProjectLines(file);
        System.out.println(num);
    }

    private static void getProjectLines(File file) throws Exception {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                getProjectLines(f);
            }
        } else {
            if (file.getName().endsWith(".java")) {
                num += getFileLines(file);
            }
        }
    }

    private static int getFileLines(File file) throws Exception {
        int result = 0;
        FileReader reader = null;
        BufferedReader br = null;
        try {
            reader = new FileReader(file);
            br = new BufferedReader(reader);
            while (br.readLine() != null) {
                result++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            br.close();
            reader.close();
        }
        return result;
    }
}