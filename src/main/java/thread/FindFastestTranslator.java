package thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 找出最快的翻译器
 */

public class FindFastestTranslator {
    private static AtomicReference<String> result = new AtomicReference(null);

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    result.compareAndSet(null, baiduTrans());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        es.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    result.compareAndSet(null, googleTrans());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        es.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    result.compareAndSet(null, wangyiTrans());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        while (null == result.get()) {
            System.out.println("----等待结果-----");
        }
        System.out.println(result.get());
    }

    private static String baiduTrans() throws InterruptedException {
        int sleepTime = new Random().nextInt(10);
        Thread.sleep(sleepTime * 1000);
        System.out.println("baidu执行了" + sleepTime + "秒");
        return "baidu";
    }

    private static String googleTrans() throws InterruptedException {
        int sleepTime = new Random().nextInt(10);
        Thread.sleep(sleepTime * 1000);
        System.out.println("google执行了" + sleepTime + "秒");
        return "google";
    }

    private static String wangyiTrans() throws InterruptedException {
        int sleepTime = new Random().nextInt(10);
        Thread.sleep(3000);
        System.out.println("wangyi执行了" + sleepTime + "秒");
        return "wangyi";
    }
}