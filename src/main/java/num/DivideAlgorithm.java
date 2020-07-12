package num;

/**
 * 除法
 */

public class DivideAlgorithm {
    public static void main(String[] args) {
        System.out.println(getResult(10, 3));
        System.out.println(getRemain(10, 3));
    }

    /**
     * 求除法结果
     */
    private static int getResult(int a, int b) {
        int result = 0;
        while (a >= b) {
           a -= b;
           result++;
        }
        return result;
    }

    /**
     * 求除法余数
     */
    private static int getRemain(int a, int b) {
        while (a >= b) {
            a -= b;
        }
        return a;
    }
}