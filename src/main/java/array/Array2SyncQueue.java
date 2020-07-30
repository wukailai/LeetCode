package array;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 数组实现同步队列
 */

public class Array2SyncQueue<T> {
    public static void main(String[] args) {

    }

    private Object[] items = new Object[10];
    private int count;
    private int takeIndex;
    private int putIndex;
    private ReentrantLock lock = new ReentrantLock();
    private Condition isEmpty = lock.newCondition();
    private Condition isFull = lock.newCondition();

    public T take() throws Exception {
        try {
            lock.lock();
            while (count == 0) {
                isEmpty.await();
            }
            T t = (T) items[takeIndex++];
            if (takeIndex == items.length) {
                takeIndex = 0;
            }
            count--;
            isFull.signal();
            return t;
        } finally {
            lock.unlock();
        }
    }

    public void put(T t) throws Exception {
        try {
            lock.lock();
            while (count == items.length) {
                isFull.await();
            }
            items[putIndex++] = t;
            if (putIndex == items.length) {
                putIndex = 0;
            }
            count++;
            isEmpty.signal();
        } finally {
            lock.unlock();
        }
    }
}