package thread;

/**
 * 自管理线程
 */
public class SelfManaged implements Runnable {
    private int countDown = 5;
    @Override
    public void run() {
        while (true){
            System.out.println(this);
            if(--countDown == 0)
                return;
        }
    }

    public SelfManaged(){
        Thread t = new Thread(this);
        t.start();
    }

    public static void main(String[] args){
        for(int i = 0; i < 5; i++){
            new SelfManaged();
        }
    }
}
