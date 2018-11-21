package thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by lixianch on 2018/10/12.
 */
public class SleepSample {
    public static void main(String[] args) {
        Runnable r1 = ()->{
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        };
        Thread t1 = new Thread(r1);
        t1.start();
        Runnable r2 = ()->{
            t1.interrupt();
        };
        Thread t2 = new Thread(r2);
        t2.start();
    }
}
