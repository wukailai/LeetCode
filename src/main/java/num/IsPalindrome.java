package num;

/**
 * 判断是否为回文整数
 */

public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(12321));
    }

    private static boolean isPalindrome(int i) {
        int reverse = 0;
        int temp = i;
        while (temp > 0) {
            int remain = temp % 10;
            reverse = reverse * 10 + remain;
            temp = temp / 10;
        }
        return reverse == i;
    }
}