package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lixianch on 2016/11/10.
 */
public class AtomicIntegerTest implements Runnable {
    private AtomicInteger v = new AtomicInteger();
    public int getValue(){
        return v.get();
    }
    public void evenIncrement(){
        v.addAndGet(2);
    }
    @Override
    public void run() {
        while(true){
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicIntegerTest ait = new AtomicIntegerTest();
        exec.execute(ait);
        while(true){
            int v = ait.getValue();
            if(v % 2 != 0){
                System.out.println(v);
                System.exit(0);
            }
        }
    }
}
