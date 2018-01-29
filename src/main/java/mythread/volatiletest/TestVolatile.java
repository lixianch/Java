package mythread.volatiletest;

/**
 * Created by lixianch on 2018/1/18.
 */
public class TestVolatile {
    private static volatile int num = 0;
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Runnable r = ()->{
                num++;
            };
            new Thread(r).start();
        }
        System.out.println(num++);
    }
}
