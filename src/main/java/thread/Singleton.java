package thread;

import java.util.concurrent.atomic.AtomicReference;

/**
 * CAS实现单例模式
 */

public class Singleton {
    private static final AtomicReference<Singleton> INSTANCE = new AtomicReference();

    private Singleton() {

    }

    private static Singleton getInstance() {
        for (;;) {
            Singleton instance = INSTANCE.get();
            if (instance != null) {
                return instance;
            }
            instance = new Singleton();
            if (INSTANCE.compareAndSet(null, instance)) {
                return instance;
            }
        }
    }

    private static Singleton getInstance2() {
        while (null == INSTANCE.get()) {
            if (INSTANCE.compareAndSet(null, new Singleton())) {
                return INSTANCE.get();
            }
        }
        return INSTANCE.get();
    }
}