package num;

import java.util.ArrayList;
import java.util.List;

/**
 * O(logn)实现幂等操作
 * 找出所有的幂等次数
 */

public class PowerOperation {
    public static void main(String[] args) {
        System.out.println(power(2, 7));
        System.out.println(get(13));
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

    private static List<Integer> get(int n) {
        List<Integer> list = new ArrayList();
        int temp = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                list.add(temp);
            }
            temp += temp;
            n = n / 2;
        }
        return list;
    }
}