package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by lixianch on 2018/4/13.
 */
public class AtomicIntegerFieldUpdatorTest {
    private volatile int count = 0;

    public static void main(String[] args) {
        AtomicIntegerFieldUpdatorTest atomicIntegerFieldUpdatorTest = new AtomicIntegerFieldUpdatorTest();
        AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdatorTest> updator = AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdatorTest.class,"count");
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            threadPool.submit(() -> {
                System.out.println(updator.incrementAndGet(atomicIntegerFieldUpdatorTest));
            });
        }
        threadPool.shutdown();
    }
}
