package num;

import java.util.ArrayList;
import java.util.List;

/**
 * O(logn)实现幂等操作
 * 找出所有的幂等次数
 */

public class PowerOperation {
    public static void main(String[] args) {
        System.out.println(power(2, 8));
        System.out.println(power2(2, 8));
        System.out.println(get(13));
        System.out.println(Decimal2Binary(8));
    }

    private static int power(int base, int power) {
        int result = 1;
        int temp = base;
        while (power > 0) {
            if (power % 2 == 1) {
                result *= temp;
            }
            temp *= temp;
            power = power / 2;
        }
        return result;
    }

    /**
     * 递归实现
     * 特别好理解
     */
    private static int power2(int base, int power) {
        if (power == 0) {
            return 1;
        }
        if (power == 1) {
            return base;
        }
        int t = power2(base, power / 2);
        if (power % 2 == 0) {
            return t * t;
        } else {
            return t * t * base;
        }
    }

    /**
     * 十进制转二进制
     */
    private static String Decimal2Binary(int n) {
        String result = "";
        while (n != 0) {
            //注意连接顺序
            result = n % 2 + result;
            n = n / 2;
        }
        return result;
    }

    /**
     * 根据十进制转二进制思想，很容易
     */
    private static List<Integer> get(int n) {
        List<Integer> list = new ArrayList();
        int temp = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                list.add(temp);
            }
            temp = 2 * temp;
            n = n / 2;
        }
        return list;
    }
}