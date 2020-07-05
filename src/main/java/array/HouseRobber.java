package array;

/**
 * @author wukailai
 * @date 2020/07/05 17:07
 * @description 抢劫房屋，连续两个房屋被抢会触发警报，典型的动态规划问题，均为正数，需要记录两个状态
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 7, 9, 3, 1};
        System.out.println(getMaxMoney(arr));
        System.out.println(getMaxMoney2(arr));
    }

    /**
     * 非递归实现
     */
    private static int getMaxMoney(int[] a) {
        if (a.length == 0) {
            return 0;
        }
        if (a.length == 1) {
            return a[0];
        }
        int first = a[0];
        int second = Math.max(a[0], a[1]);
        for (int i = 2; i < a.length; i++) {
            int temp = second;
            second = Math.max(first + a[i], second);
            first = temp;
        }
        return second;
    }

    /**
     * 数组实现
     */
    private static int getMaxMoney2(int[] a) {
        if (a.length == 0) {
            return 0;
        }
        if (a.length == 1) {
            return a[0];
        }
        int[] dp = new int[a.length];
        dp[0] = a[0];
        dp[1] = Math.max(a[0], a[1]);
        for (int i = 2; i < a.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + a[i]);
        }
        return dp[dp.length - 1];
    }
}