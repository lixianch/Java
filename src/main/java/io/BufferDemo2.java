package io;

import java.nio.ByteBuffer;

/**
 * Created by lixianch on 2019/2/1.
 */
public class BufferDemo2 {
    public static void main(String[] args) {
        ByteBuffer buffer1 = ByteBuffer.allocate(10);
        if(buffer1.hasArray()){
            System.out.println("buffer1 array: " + buffer1.array());
            System.out.println("buffer1 array offset: " + buffer1.arrayOffset());
            System.out.println("Capacity: " + buffer1.capacity());
            System.out.println("Limit: " + buffer1.limit());
            System.out.println("Position: " + buffer1.position());
            System.out.println("Remaining: " + buffer1.remaining());
            System.out.println();
        }

        byte[] bytes = new byte[200];
        ByteBuffer buffer2 = ByteBuffer.wrap(bytes);
        if(buffer2.hasArray()){
            System.out.println("buffer2 array: " + buffer2.array());
            System.out.println("buffer2 array offset: " + buffer2.arrayOffset());
            System.out.println("Capacity: " + buffer2.capacity());
            System.out.println("Limit: " + buffer2.limit());
            System.out.println("Position: " + buffer2.position());
            System.out.println("Remaining: " + buffer2.remaining());
            System.out.println();
        }
    }
}
