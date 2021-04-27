package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 多线程找出1-1000000所有素数
 */

public class FindPrime {
    private static final int TOTAL = 1000000;
    private static final int STEP = 10;
    private static final int CORE_NUM = Runtime.getRuntime().availableProcessors();
    private static ExecutorService executor = Executors.newFixedThreadPool(CORE_NUM);

    public static void main(String[] args) throws Exception {
        System.out.println("coreNum = " + CORE_NUM);
        List<Integer> result = find();
        System.out.println("resultSize = " + result.size());
        int count = 0;
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= TOTAL; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        System.out.println("单线程耗时：" + (System.currentTimeMillis() - startTime));
        System.out.println("count = " + count);
    }

    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> batchGather(int i) {
        long startTime = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();
        for (int j = i; j <= TOTAL; j = j + STEP) {
            if (isPrime(j)) {
                list.add(j);
            }
        }
        System.out.println("任务" + i + "消耗时间：" + (System.currentTimeMillis() - startTime));
        return list;
    }

    private static List<Integer> find() throws Exception {
        List<Integer> result = new ArrayList<>();
        List<Future<List<Integer>>> futureList = new ArrayList<>();
        for (int i = 1; i <= STEP; i++) {
            final int finalI = i;
            futureList.add(executor.submit(() -> batchGather(finalI)));
        }
        for (Future<List<Integer>> future : futureList) {
            result.addAll(future.get());
        }
        return result;
    }
}