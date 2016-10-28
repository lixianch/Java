package concurrency;

/**
 * Created by lixianch on 2016/9/18.
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for(int i = 0;i < 5; i++)
            new Thread(new LiftOff()).start();
        System.out.println("Waiting for LiftOff");
    }
}
