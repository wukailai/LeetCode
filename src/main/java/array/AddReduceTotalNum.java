package array;

public class AddReduceTotalNum {
    private static int count = 0;

    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 1, 1, 1};
        calculate(arr, 0, 0, 3);
        System.out.println(count);
    }

    private static void calculate(int[] a, int i, int cur, int target) {
        if (i == a.length) {
            if (cur == target) {
                count++;
            }
        } else {
            calculate(a, i + 1, cur + a[i], target);
            calculate(a, i + 1, cur - a[i], target);
        }
    }
}