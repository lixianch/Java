package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by lixianch on 2016/10/27.
 */
public class SleepingTask extends LiftOff {
    @Override
    public void run() {
        try {
            while(countDown-- >0){
                System.out.println(status());
                TimeUnit.MICROSECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++){
            exec.execute(new SleepingTask());
        }
        System.out.println("waiting for LiftOff");
    }
}
