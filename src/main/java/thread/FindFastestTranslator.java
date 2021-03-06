package thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 找出最快的翻译器
 */

public class FindFastestTranslator {
    private Random random = new Random();
    private AtomicReference<String> result = new AtomicReference();
    private ExecutorService es = Executors.newFixedThreadPool(3);
    private Map<String, Future> futureMap = new HashMap();

    public static void main(String[] args) {
        FindFastestTranslator findFastestTranslator = new FindFastestTranslator();
        findFastestTranslator.translate();
    }

    private String translate() {
        long startTime = System.currentTimeMillis();
        Future googleFuture = es.submit(() -> {
            try {
                if (result.compareAndSet(null, googleTranslate())) {
                    stopOthers();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Future baiduFuture = es.submit(() -> {
            try {
                if (result.compareAndSet(null, baiduTranslate())) {
                    stopOthers();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Future netEaseFuture = es.submit(() -> {
            try {
                if (result.compareAndSet(null, netEaseTranslate())) {
                    stopOthers();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        futureMap.put("Google", googleFuture);
        futureMap.put("Baidu", baiduFuture);
        futureMap.put("NetEase", netEaseFuture);
        while (null == result.get()) {
            //TODO
        }
        System.out.println("Combine Translator cost time: " + (System.currentTimeMillis() - startTime));
        return result.get();
    }

    private void stopOthers() {
        for (Map.Entry<String, Future> entry : futureMap.entrySet()) {
            String key = entry.getKey();
            Future future = entry.getValue();
            if (result.get().equals(key)) {
                continue;
            }
            future.cancel(true);
        }
        futureMap.clear();
    }

    private String googleTranslate() {
        long costTime = random.nextInt(5000);
        try {
            Thread.sleep(costTime);
        } catch (InterruptedException e) {
            System.out.println("Google translator has been stopped in advance");
            return null;
        }
        System.out.println("Google translator cost time: " + costTime);
        return "Google";
    }

    private String baiduTranslate() {
        long costTime = random.nextInt(5000);
        try {
            Thread.sleep(costTime);
        } catch (InterruptedException e) {
            System.out.println("Baidu translator has been stopped in advance");
            return null;
        }
        System.out.println("Baidu translator cost time: " + costTime);
        return "Baidu";
    }

    private String netEaseTranslate() {
        long costTime = random.nextInt(5000);
        try {
            Thread.sleep(costTime);
        } catch (InterruptedException e) {
            System.out.println("NetEase translator has been stopped in advance");
            return null;
        }
        System.out.println("NetEase translator cost time: " + costTime);
        return "NetEase";
    }
}