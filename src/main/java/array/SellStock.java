package array;

/**
 * @author wukailai
 * @date 2020/07/05 15:27
 * @description 卖股票寻求最大利润，只能交易一次
 */
public class SellStock {
    public static void main(String[] args) {
        int[] arr = new int[] {7, 1, 5, 3, 6, 4};
        System.out.println(getMaxProfit(arr));
    }

    private static int getMaxProfit(int[] a) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for (Integer i : a) {
            if (i < min) {
                min = i;
            }
            profit = Math.max(profit, i - min);
        }
        return profit;
    }
}