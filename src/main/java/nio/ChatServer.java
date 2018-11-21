package nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by lixianch on 2018/1/17.
 */
public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("server is running...");
        byte[] bytes = new byte[1024];
        while (true){
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            while (true) {
                int read = inputStream.read(bytes);
                if (read != -1) {
                    String info = new String(bytes, 0, read, "UTF-8");
                    System.out.println(info);
                    if("r".equals(info)){
                        break;
                    }
                }else {
                    break;
                }
            }
        }
    }
}
