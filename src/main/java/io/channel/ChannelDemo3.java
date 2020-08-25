package io.channel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by lixianch on 2019/2/11.
 */
public class ChannelDemo3 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("temp", "rw");
        FileChannel channel = raf.getChannel();
        long pos;
        System.out.println("Position = " + (pos = channel.position()));
        System.out.println("Size = " + channel.size());
        String msg = "This is a test message.";
        ByteBuffer buffer = ByteBuffer.allocate(msg.length() * 2);
        buffer.asCharBuffer().put(msg);
        channel.write(buffer);
        channel.force(true);
        System.out.println("position: " + channel.position());
        System.out.println("size = " + channel.size());
        buffer.clear();
        channel.position(pos);
        channel.read(buffer);
        buffer.flip();
        while (buffer.hasRemaining()){
            System.out.print(buffer.getChar());
        }
        System.out.println();
    }
}
