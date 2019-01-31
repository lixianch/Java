package guava.concurrency;

import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by lixianch on 2019/1/15.
 */
public class RateLimiterSampleTest {
    @Test
    public void testRateLimiter1() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        final RateLimiter rateLimiter = RateLimiter.create(2);
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 10; i++) {
            rateLimiter.acquire();
            executorService.execute(()->{
                System.out.println(System.nanoTime());
                try {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(stopwatch.elapsed());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("===============");
        }
    }

}
