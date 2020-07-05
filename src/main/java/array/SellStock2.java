package array;

/**
 * @author wukailai
 * @date 2020/07/05 15:47
 * @description 卖股票寻求最大利润，可多次交易
 */
public class SellStock2 {
    public static void main(String[] args) {
        int[] arr = new int[] {7, 1, 5, 3, 6, 4};
        System.out.println(getMaxProfit(arr));
    }

    private static int getMaxProfit(int[] a) {
        int maxProfit = 0;
        int down;
        int up;
        int i = 0;
        while (i < a.length - 1) {
            while (i < a.length - 1 && a[i] >= a[i + 1]) {
                i++;
            }
            down = a[i];
            while (i < a.length - 1 && a[i] <= a[i + 1]) {
                i++;
            }
            up = a[i];
            maxProfit += up - down;
        }
        return maxProfit;
    }
}