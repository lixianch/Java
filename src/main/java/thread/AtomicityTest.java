package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lixianch on 2016/11/10.
 */
public class AtomicityTest implements Runnable{
    private int i;
    public int getValue(){
        return i;
    }
    public synchronized void evenIncrement(){
        i++;
        i++;
    }
    @Override
    public void run() {
        while(true)
            evenIncrement();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while(true){
            int i = at.getValue();
            if(i % 2 != 0){
                System.out.println(i);
                System.exit(0);
            }

        }
    }
}
