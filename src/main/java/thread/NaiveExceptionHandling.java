package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程异常不能跨线程直接捕获
 */
public class NaiveExceptionHandling {
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        try {
            exec.execute(new ExceptionThread());
        } catch (Exception e) {
            System.out.println("捕获线程异常");
        }
        exec.shutdown();
    }
}
