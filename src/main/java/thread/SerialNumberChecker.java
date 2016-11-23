package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by lixianch on 2016/11/10.
 */
class CircularSet {
    private int[] array;
    private int size;
    private int index = 0;
    public CircularSet(int size){
        array = new int[size];
        this.size = size;
        for(int i = 0; i < size; i++){
            array[i]=-1;
        }
    }

    public synchronized  void add(int i){
        array[index++] = i;
        index = index % size;
    }

    public synchronized boolean contains(int i){
        for(int v : array){
            if(v == i)
                return true;
        }
        return false;
    }
}
public class SerialNumberChecker {
    private static final int SIZE = 10;
    private static CircularSet serials = new CircularSet(10000);
    private static ExecutorService exec = Executors.newCachedThreadPool();
    static class SerialCheck implements Runnable {

        @Override
        public void run() {
            while(true){
                int serial = SerialNumberGenerator.nextSerailNumber();
                if(serials.contains(serial)){
                    System.out.println("Duplicate:" + serial);
                    System.exit(0);
                }
                serials.add(serial);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        for(int i = 0; i < SIZE; i++) {
            exec.execute(new SerialCheck());
        }
        if(args.length > 0) {
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
            System.out.println("No duplicates detected");
            System.exit(0);
        }

    }
}
