package thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by lixianch on 2018/10/12.
 */
public class WaitSample {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Runnable r1 = ()->{
            synchronized (lock){
                System.out.println("r1获取到锁,开始进入等待");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("r1等待结束");
            }
        };
        Thread t1 = new Thread(r1);
        t1.start();
        Runnable r2 = ()->{
            synchronized (lock){
                System.out.println("r2获取锁");
            }
        };
        Thread t2 = new Thread(r2);
        System.out.println("睡眠2s");
        TimeUnit.SECONDS.sleep(2);
        t2.start();
        t2.join();
        synchronized (lock){
            lock.notifyAll();
        }
    }
}
