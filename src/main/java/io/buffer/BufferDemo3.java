package io.buffer;

import java.nio.ByteBuffer;

/**
 * Created by lixianch on 2019/2/1.
 */
public class BufferDemo3 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(7);
        System.out.println("Capacity: " + buffer.capacity());
        System.out.println("Limit: " + buffer.limit());
        System.out.println("Position: " + buffer.position());
        System.out.println("Remaining: " + buffer.remaining());
        System.out.println();

        buffer.put((byte) 10).put((byte) 20).put((byte) 30);
        System.out.println("Capacity: " + buffer.capacity());
        System.out.println("Limit: " + buffer.limit());
        System.out.println("Position: " + buffer.position());
        System.out.println("Remaining: " + buffer.remaining());
        System.out.println();

        for (int i = 0; i < buffer.position(); i++) {
            System.out.println(buffer.get(i));
        }
    }
}
