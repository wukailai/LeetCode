package array;

/**
 * @author wukailai
 * @date 2020/07/05 16:53
 * @description 获得一个数组中，出现次数超过一半的数
 * 1）map实现；2）排序，取中间值；
 */
public class GetMajorityNum {
    public static void main(String[] args) {
        int[] arr = new int[] {5, 3, 7, 3, 1, 3, 3};
        System.out.println(getMaxNum(arr));
    }

    /**
     * 摩尔投票
     */
    private static int getMaxNum(int[] a) {
        int result = -1;
        int count = 0;
        for (Integer i : a) {
            if (count == 0) {
                result = i;
            }
            if (result == i) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }
}