package bigdata.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by lixianch on 2018/1/17.
 */
public class ServiceClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.println("lixianch");
        printWriter.flush();
        System.out.println("客户端发送数据完成");
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = br.readLine();
        System.out.println("从服务器返回数据：" + s);
        br.close();
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
