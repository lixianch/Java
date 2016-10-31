package thread;


import java.util.concurrent.TimeUnit;

/**
 * 后台线程创建的子线程默认也是后台线程，即子线程的daemon属性继承父线程的daemon属性值
 */
class Daemon implements Runnable {

    @Override
    public void run() {
        Thread[] threads = new Thread[5];
        for(int i = 0; i < 5; i++){
            threads[i]=new Thread(new DaemonSpawn());
            threads[i].start();
            System.out.println("DaemonSpawn[" + i + "] started");
        }

        for(int i = 0; i < 5; i++){
            System.out.println("DaemonSpawn["+ i +"] isDaemon: " + threads[i].isDaemon());
        }
    }
}
class DaemonSpawn implements Runnable {

    @Override
    public void run() {
        while (true){
            Thread.yield();
        }
    }
}
public class Daemons {
    public static void main(String[] args) {
        Thread t = new Thread(new Daemon());
        t.setDaemon(true);
        t.start();
        try {
            TimeUnit.MICROSECONDS.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
    }
}
