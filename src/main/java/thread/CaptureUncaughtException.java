package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by lixianch on 2016/10/31.
 */
class ExceptionThread2 implements Runnable {

    @Override
    public void run() {
        throw new RuntimeException("线程异常");
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("捕获异常：" + e.getMessage());
    }
}

class ThreadHandlerFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new thread");
        Thread thread = new Thread(r);
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        return thread;
    }
}
public class CaptureUncaughtException {
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool(new ThreadHandlerFactory());
        exec.execute(new ExceptionThread2());
        exec.shutdown();
    }
}
