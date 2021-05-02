package array;

/**
 * @author wukailai
 * @date 2020/07/05 15:47
 * @description 卖股票寻求最大利润，可多次交易
 */

public class SellStock2 {
    public static void main(String[] args) {
        int[] arr = new int[] {7, 1, 5, 3, 6, 4, 5};
        System.out.println(getMaxProfit(arr));
    }

    private static int getMaxProfit(int[] a) {
        int maxProfit = 0;
        int i = 0;
        while (i < a.length) {
            while (i + 1 < a.length && a[i] >= a[i + 1]) {
                i++;
            }
            int down = a[i];
            while (i + 1 < a.length && a[i] <= a[i + 1]) {
                i++;
            }
            int up = a[i];
            maxProfit += up - down;
            i++;
        }
        return maxProfit;
    }
}