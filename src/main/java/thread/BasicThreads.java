package thread;

/**
 * Created by lixianch on 2016/10/27.
 */
public class BasicThreads {
    public static void main(String[] args){
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("waiting for LiftOff");
    }
}
