package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by lixianch on 2018/10/15.
 */
public class CyclicBarrierTest {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier barrier1 = new CyclicBarrier(2,()->{
            System.out.println("barrier1 done");
        });
        CyclicBarrier barrier2 = new CyclicBarrier(2,()->{
            System.out.println("barrier2 done");
        });
        new Thread(new BarrierTask(barrier1,barrier2)).start();
        new Thread(new BarrierTask(barrier1,barrier2)).start();
    }
}

class BarrierTask implements Runnable {
    CyclicBarrier barrier1 = null;
    CyclicBarrier barrier2 = null;
    public BarrierTask(CyclicBarrier barrier1,CyclicBarrier barrier2){
        this.barrier1 = barrier1;
        this.barrier2 = barrier2;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("barrier1 wait");
            barrier1.await();
            Thread.sleep(1000);
            System.out.println("barrier2 wait");
            barrier2.await();
            System.out.println(Thread.currentThread().getName() + " done!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
