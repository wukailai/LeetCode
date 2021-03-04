package num;

/**
 * @author wukailai
 * @date 2020/07/05 16:42
 * @description 获取阶乘0的个数
 */
public class GetZeroNum {
    public static void main(String[] args) {
        System.out.println(getZeroNum(12));
    }

    /**
     * N/5会得到所有5*1, 5*2, 5*3......的个数
     * N/25会得到所有25*1, 25*2, 25*3.....的个数
     * N/125会得到所有125*1, 125*2, 125*3.......的个数
     */
    private static int getZeroNum(int n) {
        int result = 0;
        while (n != 0) {
            result += n / 5;
            n = n / 5;
        }
        return result;
    }
}
