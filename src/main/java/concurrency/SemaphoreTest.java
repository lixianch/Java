package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by lixianch on 2018/10/15.
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.submit(()->{
                try {
                    System.out.println("waiting acquire semaphore");
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " acquire success");
                    TimeUnit.SECONDS.sleep(10);
                    semaphore.release();
                    System.out.println("release success");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}
