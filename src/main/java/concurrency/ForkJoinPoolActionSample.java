package concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * Created by lixianch on 2018/4/17.
 */
public class ForkJoinPoolActionSample {
    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        PrintTask task = new PrintTask(1,300);
        forkJoinPool.submit(task);
        forkJoinPool.awaitTermination(1000, TimeUnit.SECONDS);
        forkJoinPool.shutdown();
    }
}

class PrintTask extends RecursiveAction {
    public static final int THRESHOLD = 50;
    private int start;
    private int end;

    public PrintTask(Integer start,Integer end){
        this.start = start;
        this.end = end;
    }
    @Override
    protected void compute() {
        if(end - start < THRESHOLD){
            for(int i = start; i < end; i++){
                System.out.println(Thread.currentThread().getName() + " 值是" + i);
            }
        }else {
            int middle = (end + start) / 2;
            PrintTask left = new PrintTask(start,middle);
            PrintTask right = new PrintTask(middle,end);
            left.fork();
            right.fork();
        }
    }
}
