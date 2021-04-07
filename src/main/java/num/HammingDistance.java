package num;

/**
 * Hamming Distance
 */

public class HammingDistance {
    public static void main(String[] args) {
        System.out.println(getDistance(1, 4));
        System.out.println(getDistance(3, 4));
        System.out.println(getDistance(31, 41));
    }

    private static int getDistance(int x, int y) {
        int result = 0;
        while (x > 0 || y > 0) {
            result += x % 2 ^ y % 2;
            x = x / 2;
            y = y / 2;
        }
        return result;
    }
}