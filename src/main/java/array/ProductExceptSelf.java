package array;

import java.util.Arrays;

/**
 * 数组除了自己之和
 */

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 5};
        System.out.println(Arrays.toString(product(arr)));
    }

    private static int[] product(int[] a) {
        int[] m = new int[a.length];
        int[] n = new int[a.length];
        m[0] = 1;
        for (int i = 1; i < a.length; i++) {
            m[i] = m[i - 1] * a[i - 1];
        }
        n[a.length - 1] = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            n[i] = n[i + 1] * a[i + 1];
        }
        for (int i = 0; i < a.length; i++) {
            m[i] *= n[i];
        }
        return m;
    }
}