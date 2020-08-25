package io.channel;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by lixianch on 2019/2/11.
 */
public class ChannelDemo5 {
    public static void main(String[] args) throws IOException{
        if(args.length != 1){
            System.out.println("Usage: ChannelDemo5 filespec");
            return;
        }
        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
        FileChannel channel = raf.getChannel();
        long size = channel.size();
        System.out.println("Size: " + size);
        MappedByteBuffer mmap = channel.map(FileChannel.MapMode.READ_WRITE, 0, size);
        while (mmap.remaining() > 0){
            System.out.println((char) mmap.get());
        }
        System.out.println();
        System.out.println();
        for (int i = 0 ; i < mmap.limit() / 2; i++){
            byte b1 = mmap.get(i);
            byte b2 = mmap.get(mmap.limit() - i - 1);
            mmap.put(i, b2);
            mmap.put(mmap.limit() - i - 1, b1);
        }

        mmap.flip();
        while (mmap.remaining() > 0){
            System.out.println((char) mmap.get());
        }
        channel.close();
    }
}
