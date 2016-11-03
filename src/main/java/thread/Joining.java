package thread;

/**
 * Created by lixianch on 2016/11/2.
 */
class Sleeper extends Thread {
    private int duration;
    public Sleeper(String name,int duration){
        super(name);
        this.duration=duration;
        start();
    }
    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted,isInterrupted():"+isInterrupted());
        }
        System.out.println(getName() + " has awakend");
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;
    public Joiner(String name,Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        System.out.println(getName()+" thread start");
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(getName()+ " have completed");
    }
}
public class Joining {
    public static void main(String[] args){
        Sleeper
                sleepy = new Sleeper("Sleepy", 1500),
                grumpy = new Sleeper("Grumpy", 1500);
        Joiner
                dopey = new Joiner("Dopey", sleepy),
                doc = new Joiner("Doc", grumpy);
        grumpy.interrupt();
    }
}
