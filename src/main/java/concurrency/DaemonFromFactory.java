package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by lixianch on 2016/9/19.
 */
public class DaemonFromFactory implements Runnable{
    @Override
    public void run() {
        try {
            while(true){
                TimeUnit.MICROSECONDS.sleep(100);
                System.out.println(Thread.currentThread() + ": " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }

    public static void main(String[] args) {
        try {
            ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
            for(int i = 0; i < 10; i++){
                exec.execute(new DaemonFromFactory());
            }

            System.out.println("All daemons started");
            TimeUnit.MICROSECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
