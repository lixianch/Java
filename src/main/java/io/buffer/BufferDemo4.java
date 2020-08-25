package io.buffer;

import java.nio.CharBuffer;

/**
 * Created by lixianch on 2019/2/1.
 */
public class BufferDemo4 {
    static String[] poem = {
                    "Roses are red",
                    "Violets are blue",
                    "Sugar is sweet",
                    "And so are you."
            };
    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(50);
        for (String s : poem) {
            for (int i = 0; i < s.length(); i++) {
                buffer.put(s.charAt(i));
            }
            buffer.flip();
            while (buffer.hasRemaining()){
                System.out.print(buffer.get());
            }
            buffer.clear();
            System.out.println();
        }
    }
}
