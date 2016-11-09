package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lixianch on 2016/11/9.
 */
public class MutexEventGenerator extends IntGenerator {
    private int currentValue = 0;
    Lock lock = new ReentrantLock();
    @Override
    public int next() {
        try {
            lock.lock();
            ++currentValue;
            Thread.yield();
            ++currentValue;
            return currentValue;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEventGenerator());
    }
}
