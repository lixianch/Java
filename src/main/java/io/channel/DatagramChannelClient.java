package io.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * Created by lixianch on 2019/2/11.
 */
public class DatagramChannelClient {
    public static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        if(args.length != 1){
            System.err.println("Usage:java DatagramChannelClient stockSymbol");
            return;
        }
        DatagramChannel dc = DatagramChannel.open();
        ByteBuffer symbol = ByteBuffer.wrap(args[0].getBytes());
        ByteBuffer response = ByteBuffer.allocate(16);

        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", PORT);
        dc.send(symbol, inetSocketAddress);
        System.out.println("Receiving datagram from " + dc.receive(response));
        System.out.println("Open price: " + response.getFloat(0));
        System.out.println("Low price: " + response.getFloat(4));
        System.out.println("High price: " + response.getFloat(8));
        System.out.println("Close price: " + response.getFloat(12));
    }
}
