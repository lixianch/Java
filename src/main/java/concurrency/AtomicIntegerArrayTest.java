package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by lixianch on 2018/4/13.
 */
public class AtomicIntegerArrayTest {
    static int[] array = new int[]{1,2,3,4,5};
    private static AtomicIntegerArray aig = new AtomicIntegerArray(array);

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            Runnable task = () -> {
                if(aig.compareAndSet(2,3,7)){
                    System.out.println("Update Array element");
                }
            };
            threadPool.submit(task);
        }
        threadPool.shutdown();
        System.out.println(aig.toString());
    }
}
