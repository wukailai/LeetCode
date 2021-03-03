package array;

/**
 * 非降序数组中目标数出现次数
 * 第二种解法更推荐
 */
public class NumAppearTimes {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 6, 6, 6, 6};
        int target = 6;
        System.out.println(getTimes(arr, target));
        System.out.println(getTimes2(arr, target));
    }

    private static int getTimes(int[] a, int target) {
        if (null == a) {
           return 0;
        }
        if (a.length < 1) {
            return 0;
        }
        if (a[0] > target || a[a.length - 1] < target) {
            return 0;
        }
        int index = getIndex(a, 0, a.length - 1, target);
        if (index == -1) {
            return 0;
        }
        int left = getLeft(a, 0, index, target);
        int right = getRight(a, index, a.length - 1, target);
        return right - left + 1;
    }

    private static int getIndex(int[] a, int start, int end, int target) {
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (a[mid] == target) {
                return mid;
            }
            if (a[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int getLeft(int[] a, int start, int end, int target) {
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (a[mid] == target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    private static int getRight(int[] a, int start, int end, int target) {
        while (start < end) {
            //这个地方为什么+1无法理解
            int mid = (end + 1 - start) / 2 + start;
            if (a[mid] == target) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    /**
     * 更推荐
     */
    private static int getTimes2(int[] a, int target) {
        if (null == a) {
            return 0;
        }
        if (a.length < 1) {
            return 0;
        }
        if (a[0] > target || a[a.length - 1] < target) {
            return 0;
        }
        float target1 = (float) (target - 0.5);
        float target2 = (float) (target + 0.5);
        int index1 = getIndex(a, 0, a.length - 1, target1);
        int index2 = getIndex(a, 0, a.length - 1, target2);
        return index2 - index1;
    }

    private static int getIndex(int[] a, int start, int end, float target) {
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (a[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}