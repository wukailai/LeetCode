package array2;

import util.PrinterUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 重组队列
 */

public class ReconstructQueue {
    public static void main(String[] args) {
        int[][] arr = new int[][] {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        PrinterUtil.printArray(arr);
        int[][] result = reconstruct(arr);
        System.out.println("====================");
        PrinterUtil.printArray(result);
    }

    private static int[][] reconstruct(int[][] arr) {
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i][1], arr[i]);
        }
        return list.toArray(new int[arr.length][2]);
    }
}