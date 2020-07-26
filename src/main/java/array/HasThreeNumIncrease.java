package array;

/**
 * 判断数组中是否有三个升序数字
 */

public class HasThreeNumIncrease {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5};
        System.out.println(exist(arr));
    }

    private static boolean exist(int[] a) {
        if (a.length < 3) {
            return false;
        }
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (Integer i : a) {
            if (i <= first) {
                first = i;
            } else if (i <= second) {
                second = i;
            } else {
                return true;
            }
        }
        return false;
    }
}