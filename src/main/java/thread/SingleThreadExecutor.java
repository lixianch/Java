package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lixianch on 2016/10/27.
 */
public class SingleThreadExecutor {
    public static void main(String[] args){
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for(int i =0; i < 5; i++){
            exec.execute(new LiftOff());
        }
        System.out.println("waiting for LiftOff");
        exec.shutdown();
    }
}
