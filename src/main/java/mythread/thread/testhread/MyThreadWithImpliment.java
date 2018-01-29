package mythread.thread.testhread;

/**
 * Created by lixianch on 2018/1/18.
 */
public class MyThreadWithImpliment implements Runnable {
    private Integer x;
    public MyThreadWithImpliment(Integer x){
        this.x = x;
    }
    @Override
    public void run() {
        System.out.println("线程" + Thread.currentThread().getName() +"被调用:");
        for (int i = 0; i < 10; i++) {
            System.out.println(x + ":" + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThreadWithImpliment(1),"thread1");
        Thread thread2 = new Thread(new MyThreadWithImpliment(2),"thread2");
        thread1.start();
        thread2.start();
    }
}
