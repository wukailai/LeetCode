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
    private Condition takeCondition = lock.newCondition();
    private Condition putCondition = lock.newCondition();

    public T take() throws Exception {
        try {
            lock.lock();
            //注意：这里用while不用if
            while (count == 0) {
                takeCondition.await();
            }
            T t = (T) items[takeIndex++];
            if (takeIndex == items.length) {
                takeIndex = 0;
            }
            count--;
            putCondition.signal();
            return t;
        } finally {
            lock.unlock();
        }
    }

    public void put(T t) throws Exception {
        try {
            lock.lock();
            //注意：这里用while不用if
            while (count == items.length) {
                putCondition.await();
            }
            items[putIndex++] = t;
            if (putIndex == items.length) {
                putIndex = 0;
            }
            count++;
            takeCondition.signal();
        } finally {
            lock.unlock();
        }
    }
}