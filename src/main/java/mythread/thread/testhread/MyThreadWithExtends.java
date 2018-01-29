package mythread.thread.testhread;

import java.util.concurrent.TimeUnit;

/**
 * Created by lixianch on 2018/1/18.
 */
public class MyThreadWithExtends extends Thread {
    private Integer x;
    public MyThreadWithExtends(Integer x){
        this.x = x;
    }
    @Override
    public void run() {
        System.out.println("线程"+Thread.currentThread().getName()+"被调用");
        for (int i = 0; i < 10; i++) {
            System.out.println(x + ":" +i);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyThreadWithExtends thread1 = new MyThreadWithExtends(1);
        MyThreadWithExtends thread2 = new MyThreadWithExtends(2);
        thread1.start();
        thread2.start();
    }
}
