package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 死锁
 */

public class DeadLock {
    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();

    private void deadLock() {
        new Thread(
                new Runnable() {
                    public void run() {
                        System.out.println("线程1开始执行");
                        lock1.lock();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        lock2.lock();
                        System.out.println("线程1结束执行");
                    }
                }
        ).start();
        new Thread(
                new Runnable() {
                    public void run() {
                        System.out.println("线程2开始执行");
                        lock2.lock();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        lock1.lock();
                        System.out.println("线程2结束执行");
                    }
                }
        ).start();
    }

    public static void main(String[] args) {
        new DeadLock().deadLock();
    }
}