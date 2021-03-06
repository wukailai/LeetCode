package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 死锁
 */

public class DeadLock {
    private static Lock lock1 = new ReentrantLock();
    private static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(
                () -> {
                    try {
                        lock1.lock();
                        System.out.println(Thread.currentThread().getName() + "拿到了lock1锁");
                        Thread.sleep(1000);
                        lock2.lock();
                        System.out.println(Thread.currentThread().getName() + "拿到了lock2锁");
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock1.unlock();
                        lock2.unlock();
                    }
                }, "线程1"
        ).start();
        new Thread(
                () -> {
                    try {
                        lock2.lock();
                        System.out.println(Thread.currentThread().getName() + "拿到了lock2锁");
                        Thread.sleep(1000);
                        lock1.lock();
                        System.out.println(Thread.currentThread().getName() + "拿到了lock1锁");
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock2.unlock();
                        lock1.unlock();
                    }
                }, "线程2"
        ).start();
    }
}