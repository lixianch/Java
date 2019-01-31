package io.classic;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

import static org.hamcrest.Matchers.*;

/**
 * Created by lixianch on 2019/1/30.
 */
public class RandomAccessFileTest {
    @Test
    public void testRandomAccessFile() throws Exception{
        File file = new File("test.txt");
        if(!file.exists()){
            boolean newFile = file.createNewFile();
            assertThat(newFile, is(true));
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile("test.txt", "rw");
//        randomAccessFile.write("hello world".getBytes());
//        randomAccessFile.seek(2);
//        int read = randomAccessFile.read();
//        System.out.println((char) read);
//        randomAccessFile.seek(0);
        FileChannel channel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(2);
        int count = channel.read(byteBuffer);
        while (count > 0) {
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                char c = (char)byteBuffer.get();
                System.out.println(c);
            }
            byteBuffer.compact();
            count = channel.read(byteBuffer);
        }
        randomAccessFile.close();
    }
}
