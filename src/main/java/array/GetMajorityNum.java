package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wukailai
 * @date 2020/07/05 16:53
 * @description 获得一个数组中，出现次数超过一半的数
 * 1）map实现；2）排序，取中间值；
 */

public class GetMajorityNum {
    public static void main(String[] args) {
        int[] arr = new int[] {5, 3, 7, 3, 1, 3, 3, 3, 2};
        System.out.println(getMaxNum(arr));
        int[] arr2 = new int[] {5, 4, 5, 3, 5, 3, 3};
        System.out.println(getMaxNum2(arr2));
    }

    /**
     * 摩尔投票，查找超过二分之一的数，最多一个
     */
    private static int getMaxNum(int[] a) {
        int major = a[0];
        int count = 1;
        for (int i = 1; i < a.length; i++) {
            if (count == 0) {
                major = a[i];
                count = 1;
            }
            if (a[i] == major) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }

    /**
     * 摩尔投票，查找超过三分之一的数，最多一个
     */
    private static List<Integer> getMaxNum2(int[] arr) {
        int a = arr[0];
        int b = arr[0];
        int an = 0;
        int bn = 0;
        for (Integer i : arr) {
            if (a == i) {
                an++;
                a = i;
                continue;
            }
            if (b == i) {
                bn++;
                b = i;
                continue;
            }
            if (an == 0) {
                an++;
                a = i;
                continue;
            }
            if (bn == 0) {
                bn++;
                b = i;
                continue;
            }
            bn--;
            an--;
        }
        an = 0;
        bn = 0;
        for (Integer i : arr) {
            if (i == a) {
                an++;
            } else if (i == b) {
                bn++;
            }
        }
        List<Integer> result = new ArrayList();
        if (an > arr.length / 3) {
            result.add(a);
        }
        if (bn > arr.length / 3) {
            result.add(b);
        }
        return result;
    }
}