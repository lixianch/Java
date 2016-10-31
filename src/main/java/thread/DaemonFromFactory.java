package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by lixianch on 2016/10/31.
 */
public class DaemonFromFactory {
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for(int i = 0; i < 5; i++){
            exec.execute(new LiftOff());
        }
        try {
            TimeUnit.MICROSECONDS.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        exec.shutdown();
    }
}
