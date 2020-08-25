package io.channel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by lixianch on 2019/2/11.
 */
public class ChannelDemo4 {
    public static final int MAXQUERIES = 150000;
    public static final int MAXUPDATES = 150000;
    public static final int RECLEN = 16;
    static ByteBuffer buffer = ByteBuffer.allocate(RECLEN);
    static IntBuffer intBuffer = buffer.asIntBuffer();
    static int counter = 1;
    public static void main(String[] args) throws IOException {
        boolean writer = false;
        if(args.length != 0)
            writer = true;
        RandomAccessFile raf = new RandomAccessFile("temp", writer ? "rw" : "r");
        FileChannel channel = raf.getChannel();
        if(writer)
            update(channel);
        else
            query(channel);
    }

    private static void query(FileChannel channel) throws IOException {
        for (int i = 0; i < MAXQUERIES; i++) {
            System.out.println("acquiring shared lock");
            FileLock lock = channel.lock(RECLEN * i, RECLEN, true);
            try {
                buffer.clear();
                channel.read(buffer);
                int a = intBuffer.get(0);
                int b = intBuffer.get(1);
                int c = intBuffer.get(2);
                int d = intBuffer.get(3);
                System.out.println("Reading: " + a + " " + b + " " + c + " " + d);
                if(a * 2 != b || a * 3 != c || a * 4 != d){
                    System.out.println("Error");
                    return;
                }
            }catch (IOException e){
                e.printStackTrace();
            } finally {
                try {
                    lock.release();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void update(FileChannel channel) throws IOException{
        for (int i = 0; i < MAXUPDATES; i++) {
            System.out.println("acquiring exclusive lock");
            FileLock lock = channel.lock(RECLEN * i, RECLEN, false);
            try {
                buffer.clear();
                intBuffer.clear();
                int a = counter;
                int b = counter * 2;
                int c = counter * 3;
                int d = counter * 4;
                System.out.println("Writing: " + a + " " + b + " " + c + " " + d);
                intBuffer.put(a);
                intBuffer.put(b);
                intBuffer.put(c);
                intBuffer.put(d);
                counter++;
                channel.write(buffer);
            }catch (IOException e){
                e.printStackTrace();
            } finally {
                try {
                    lock.release();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
