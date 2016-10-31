package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程抛出异常
 */
public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        throw  new RuntimeException("thread exception");
    }

    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
        exec.shutdown();
    }
}
