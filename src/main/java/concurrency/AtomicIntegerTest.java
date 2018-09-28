package concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lixianch on 2018/4/13.
 */
public class AtomicIntegerTest {
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(10000);
        for(int i = 0; i < 10000; i++){
            Runnable task = () -> {
                count.incrementAndGet();
                countDownLatch.countDown();
            };
            threadPool.submit(task);
        }
        threadPool.shutdown();
        countDownLatch.await();
        System.out.println(count.get());
    }
}
