package io.channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.util.Random;

/**
 * Created by lixianch on 2019/2/11.
 */
public class ChannelDemo7 {
    public static final int BUFSIZE = 10;
    public static final int LIMIT = 3;

    public static void main(String[] args) throws IOException {
        Pipe pipe = Pipe.open();
        Runnable senderTask = ()->{
            try {
                Pipe.SinkChannel sink = pipe.sink();
                ByteBuffer buffer = ByteBuffer.allocate(BUFSIZE);
                for (int i = 0; i < LIMIT; i++) {
                    buffer.clear();
                    for (int i1 = 0; i1 < BUFSIZE; i1++) {
                        buffer.put((byte)(Math.random() * 256));
                    }
                    buffer.flip();
                    while(sink.write(buffer)>0);
                }
                sink.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        Runnable receiverTask = ()->{
            try {
                Pipe.SourceChannel source = pipe.source();
                ByteBuffer buffer = ByteBuffer.allocate(BUFSIZE);
                while (source.read(buffer) > 0){
                    buffer.flip();
                    while (buffer.hasRemaining()){
                        System.out.println(buffer.get() & 255);
                    }
                    buffer.clear();
                }
                source.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        new Thread(senderTask).start();
        new Thread(receiverTask).start();
    }
}
