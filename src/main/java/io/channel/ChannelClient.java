package io.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by lixianch on 2019/2/11.
 */
public class ChannelClient {
    public static void main(String[] args) {
        try {
            SocketChannel sc = SocketChannel.open();
            sc.configureBlocking(false);
            InetSocketAddress address = new InetSocketAddress("localhost", 9999);
            sc.connect(address);
            while (!sc.finishConnect()){
                System.out.println("waiting to finish connection");
            }
            ByteBuffer buffer = ByteBuffer.allocate(2000);
            while (sc.read(buffer) > 0){
                buffer.flip();
                while (buffer.hasRemaining()){
                    System.out.print((char)buffer.get());
                }
                buffer.clear();
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }
}
