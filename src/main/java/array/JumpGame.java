package array;

/**
 * 跳跃游戏
 */

public class JumpGame {
    public static void main(String[] args) {
        int[] arr = new int[] {3, 2, 1, 0, 4};
        int[] arr2 = new int[] {2, 3, 0, 0, 0, 1, 1, 4};
        int[] arr3 = new int[] {2, 3, 1, 1, 4};
        System.out.println(canJump(arr));
        System.out.println(canJump(arr2));
        System.out.println(canJump(arr3));
    }

    private static boolean canJump(int[] a) {
        int reach = 0;
        for (int i = 0; i < a.length - 1; i++) {
            //这个if判断很关键
            if (i <= reach) {
                reach = Math.max(reach, a[i] + i);
                if (reach >= a.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}