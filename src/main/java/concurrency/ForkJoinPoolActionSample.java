package concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * Created by lixianch on 2018/4/17.
 */
public class ForkJoinPoolActionSample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(9);
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        PrintTask task = new PrintTask(1,10,latch);
        forkJoinPool.submit(task);
//        forkJoinPool.awaitTermination(1000, TimeUnit.SECONDS);
        latch.await();
        forkJoinPool.shutdown();
    }
}

class PrintTask extends RecursiveAction {
    public static final int THRESHOLD = 3;
    private CountDownLatch latch;
    private int start;
    private int end;

    public PrintTask(Integer start,Integer end,CountDownLatch latch){
        this.start = start;
        this.end = end;
        this.latch = latch;
    }
    @Override
    protected void compute() {
        if(end - start < THRESHOLD){
            for(int i = start; i < end; i++){
                System.out.println(Thread.currentThread().getName() + " 值是" + i);
                latch.countDown();
            }
        }else {
            int middle = (end + start) / 2;
            PrintTask left = new PrintTask(start,middle,latch);
            PrintTask right = new PrintTask(middle,end,latch);
            left.fork();
            right.fork();
        }
    }
}
