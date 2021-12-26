package array;

public class FindDuplicateNumber2 {
    public static void main(String[] args) {
//        int[] arr = new int[] {2, 3, 1, 0, 2, 5, 3};
        int[] arr = new int[] {6, 3, 1, 0, 2, 5, 3};
        System.out.println(findDuplicate(arr));
    }

    private static int findDuplicate(int[] a) {
        int i = 0;
        while (i < a.length) {
            if (a[i] == i) {
               i++;
               continue;
            }
            if (a[a[i]] == a[i]) {
                return a[i];
            }
            int temp = a[i];
            a[i] = a[temp];
            a[temp] = temp;
        }
        return -1;
    }
}
