package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created by lixianch on 2018/4/13.
 */
public class AtomicStampReferenceTest {
    public static void main(String[] args) {
        AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(0,0);
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            threadPool.submit(() -> {
                stampedReference.compareAndSet(0,1,0,1);
            });
        }
        threadPool.shutdown();
    }
}
