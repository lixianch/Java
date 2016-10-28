package concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by lixianch on 2016/9/18.
 */
public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        try {
            while (true){
                TimeUnit.MICROSECONDS.sleep(100);
                System.out.println(Thread.currentThread() + ": " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            Thread t = new Thread(new SimpleDaemons());
            t.setDaemon(true);
            t.start();
        }
        System.out.println("All daemons started");
        try {
            TimeUnit.MICROSECONDS.sleep(175);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
