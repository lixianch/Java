package io.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * Created by lixianch on 2019/2/11.
 */
public class DatagramChannelServer {
    public static final int PORT = 9999;
    public static void main(String[] args) throws IOException{
        System.out.println("server starting and listening on port " +
                PORT + " for incoming requests...");
        DatagramChannel dc = DatagramChannel.open();
        dc.socket().bind(new InetSocketAddress(PORT));
        ByteBuffer symbal = ByteBuffer.allocate(4);
        ByteBuffer payload = ByteBuffer.allocate(16);
        while (true){
            symbal.clear();
            payload.clear();
            SocketAddress socketAddress = dc.receive(symbal);
            if(socketAddress == null){
                return;
            }
            System.out.println("Received request from " + socketAddress);
            String stockSymbal = new String(symbal.array(), 0, 4);
            if (stockSymbal.toUpperCase().equals("MSFT")) {
                payload.putFloat(0, 37.40f);
                payload.putFloat(4, 37.22f);
                payload.putFloat(8, 37.48f);
                payload.putFloat(12, 37.41f);
            }else {
                payload.putFloat(0, 0.0f);
                payload.putFloat(4, 0.0f);
                payload.putFloat(8, 0.0f);
                payload.putFloat(12, 0.0f);
            }
            dc.send(payload, socketAddress);
        }
    }
}
