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

    private static int getZeroNum(int n) {
        int result = 0;
        while (n != 0) {
            result += n / 5;
            n = n / 5;
        }
        return result;
    }
}
