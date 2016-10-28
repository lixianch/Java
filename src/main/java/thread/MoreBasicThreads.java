package thread;

/**
 * Created by lixianch on 2016/10/27.
 */
public class MoreBasicThreads {
    public static void main(String[] args){
        for(int i = 0; i < 5; i++){
            new Thread(new LiftOff()).start();
        }
        System.out.println("waiting for LiftOff");
    }
}
