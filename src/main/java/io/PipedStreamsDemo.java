package io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by lixianch on 2019/1/31.
 */
public class PipedStreamsDemo {
    public static final int LIMIT = 10;
    public static void main(String[] args) throws IOException {
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream(pis);

        Runnable senderTask = () ->{
            try {
                TimeUnit.SECONDS.sleep(5);
                for (int i = 0; i < LIMIT; i++) {
                    pos.write((byte)(Math.random() * 256));
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if(pos != null){
                    try {
                        pos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable receiverTask = ()->{
            int b;
            try {
                while((b = pis.read()) != -1){
                    System.out.println(b);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(pis != null){
                    try {
                        pis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        executorService.execute(receiverTask);
        executorService.execute(senderTask);
        executorService.shutdown();
    }
}
