package io.channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Created by lixianch on 2019/2/11.
 */
public class ChannelDemo {
    public static void main(String[] args) {
        ReadableByteChannel src = Channels.newChannel(System.in);
        WritableByteChannel dest = Channels.newChannel(System.out);
        try {
//            copy(src, dest);
            copyAlt(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                src.close();
                dest.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void copy(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(2048);
        while (src.read(byteBuffer) != -1){
            byteBuffer.flip();
            dest.write(byteBuffer);
            byteBuffer.compact();
        }
        byteBuffer.flip();
        if(byteBuffer.hasRemaining()){
            dest.write(byteBuffer);
        }
    }

    private static void copyAlt(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(2048);
        while (src.read(byteBuffer) != -1){
            byteBuffer.flip();
            while(byteBuffer.hasRemaining()){
                dest.write(byteBuffer);
            }
            byteBuffer.clear();
        }
    }
}
