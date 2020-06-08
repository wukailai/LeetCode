package num;

/**
 * 反转整数
 */

public class ReverseInt {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(20));
        System.out.println(reverse(10000));

        System.out.println("=========================");

        System.out.println(reverse2(123));
        System.out.println(reverse2(-123));
        System.out.println(reverse2(20));
        System.out.println(reverse2(10000));
    }

    /**
     * 有优化空间
     */
    private static int reverse(int target) {
        int len = 0;
        String targetStr = "" + target;
        if (target >= 0) {
            len = targetStr.length();
        } else if (target < 0) {
            len = targetStr.length() - 1;
        }
        int result = 0;
        int temp = target;
        while (temp != 0) {
            int remain = temp % 10;
            result += remain * Math.pow(10, --len);
            temp = temp / 10;
        }
        return result;
    }

    /**
     * 解法2
     */
    private static int reverse2(int target) {
        int result = 0;
        while (target != 0) {
            int remain = target % 10;
            result = 10 * result + remain;
            target = target / 10;
        }
        return result;
    }
}