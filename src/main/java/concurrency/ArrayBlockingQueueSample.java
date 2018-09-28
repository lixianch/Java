package concurrency;

import java.util.concurrent.*;

/**
 * Created by lixianch on 2018/4/13.
 */
public class ArrayBlockingQueueSample {
    public static void main(String[] args) {
        BlockingQueue<String> arrayQueue = new ArrayBlockingQueue<String>(10);
        ExecutorService threadPool = Executors.newCachedThreadPool();
        threadPool.submit(() -> {
            try {
                for (int i = 0; i < 100; i++) {
//                    Thread.sleep(500);
                    String v = i + "";
                    System.out.println("put " + v);
                    arrayQueue.put(v);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPool.submit(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(500);
                    String v = arrayQueue.take();
                    System.out.println(v);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPool.shutdown();
    }
}
