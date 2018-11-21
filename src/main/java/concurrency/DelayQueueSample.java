package concurrency;

import java.util.concurrent.*;

/**
 * Created by lixianch on 2018/10/12.
 */
public class DelayQueueSample {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayElement> queue = new DelayQueue<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(()->{
            for (int i = 0; i < 10; i++) {
                DelayElement e = new DelayElement(i);
                System.out.println(e.getDelay(TimeUnit.NANOSECONDS));
                queue.add(e);
                System.out.println("add " + i);
            }
        });
        executorService.submit(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    DelayElement e = queue.take();
                    System.out.println("take " + e.getTime());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        TimeUnit.SECONDS.sleep(10);
        executorService.shutdown();
    }

    static class DelayElement implements Delayed {
        private Long time;
        public DelayElement(int i){
            System.out.println("random value" + i);
            this.time = System.nanoTime() + i * 1000;
        }
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.time - System.nanoTime(),TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return this.compareTo(o);
        }

        public Long getTime() {
            return time;
        }
    }
}
