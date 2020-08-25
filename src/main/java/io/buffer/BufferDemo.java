package io.buffer;

import java.nio.ByteBuffer;

/**
 * Created by lixianch on 2019/2/1.
 */
public class BufferDemo {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(7);
        System.out.println("Capacity: " + byteBuffer.capacity());
        System.out.println("Limit: " + byteBuffer.limit());
        System.out.println("Position: " + byteBuffer.position());
        System.out.println("Remaining: " + byteBuffer.remaining());

        System.out.println("Changing buffer limit 5");
        byteBuffer.limit(5);
        System.out.println("Limit: " + byteBuffer.limit());
        System.out.println("Position: " + byteBuffer.position());
        System.out.println("Remaining: " + byteBuffer.remaining());

        System.out.println("Changing buffer position to 3");
        byteBuffer.position(3);
        System.out.println("Limit: " + byteBuffer.limit());
        System.out.println("Position: " + byteBuffer.position());
        System.out.println("Remaining: " + byteBuffer.remaining());
    }
}
