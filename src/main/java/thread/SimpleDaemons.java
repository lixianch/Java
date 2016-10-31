package thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by lixianch on 2016/10/31.
 */
public class SimpleDaemons implements Runnable{

    @Override
    public void run() {
        try {
            while (true){
                System.out.println(Thread.currentThread() + ":" + this);
                TimeUnit.MICROSECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }

    public static void main(String[] args){
        Thread daemon = null;
        try {
            for(int i = 0; i < 5; i++){
                daemon = new Thread(new SimpleDaemons());
                daemon.setDaemon(true);
                daemon.start();
                TimeUnit.MICROSECONDS.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
    }
}
