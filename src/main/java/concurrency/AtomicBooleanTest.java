package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lixianch on 2018/4/13.
 */
public class AtomicBooleanTest {
    private static AtomicBoolean flag = new AtomicBoolean(false);
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10000; i++) {
            Runnable produceTask = () -> {
                if(flag.compareAndSet(false,true)){
                    System.out.println("Update flag");
                }
            };
            threadPool.submit(produceTask);
        }
        threadPool.shutdown();
    }
}
