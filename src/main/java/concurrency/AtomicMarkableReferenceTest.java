package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * Created by lixianch on 2018/4/13.
 */
public class AtomicMarkableReferenceTest {
    public static void main(String[] args) {
        AtomicMarkableReference<Integer> markableReference = new AtomicMarkableReference<>(0,false);
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            threadPool.submit(() -> {
                if(markableReference.compareAndSet(0,0,false,true)){
                    System.out.println("Update value");
                }
            });
        }
        threadPool.shutdown();
    }
}
