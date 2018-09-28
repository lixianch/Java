package concurrency;

import org.apache.commons.math.stat.descriptive.summary.Sum;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by lixianch on 2018/4/17.
 */
public class ForkJoinPoolTaskSample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        SumTask task = new SumTask(1,100);
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(task);
        Integer sum = forkJoinTask.get();
        System.out.println("值" + sum);
    }
}

class SumTask extends RecursiveTask<Integer> {
    public static final int THRESHOLD = 2;
    private Integer start;
    private Integer end;
    public SumTask(Integer start,Integer end){
        super();
        this.start = start;
        this.end = end;
    }
    @Override
    protected Integer compute() {
        if(end - start < THRESHOLD){
            System.out.println("值:" + start + ":" +end);
            if(start == end){
                return end;
            }
            return start + end;
        }else {
            Integer middle = (end + start) / 2;
            SumTask left = new SumTask(start,middle);
            SumTask right = new SumTask(middle + 1,end);
            left.fork();
            right.fork();
            int sum = left.join() + right.join();
            System.out.println(Thread.currentThread().getName() + "值:" + sum);
            return sum;
        }
    }
}
