package thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by lixianch on 2016/11/1.
 */
class ADaemon implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Starting ADaemon");
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Exiting via interruptedException");
        } finally {
            System.out.println("daemon thread finally execute");
        }

    }
}
public class DaemonsDontRunFinally {
    public static void main(String[] args){
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
    }
}
