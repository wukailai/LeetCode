package num;

/**
 * 换瓶子：三个空汽水瓶可以换一瓶汽水，如果最后剩两个瓶子，可以让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板
 * 求最多可以换多少瓶汽水喝
 */

public class ExchangeBottles {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(exchange(n));
    }

    private static int exchange(int n) {
        int result = 0;
        while (n >= 3) {
            int remain = n % 3;
            n = n / 3;
            result += n;
            n += remain;
        }
        if (n == 2) {
            result++;
        }
        return result;
    }

    private static int exchange(int n, int m) {
        int result = 0;
        while (n >= m) {
            int remain = n % m;
            n = n / m;
            result += n;
            n += remain;
        }
        return result;
    }
}