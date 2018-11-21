package nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lixianch on 2018/1/17.
 */
public class ThreadPoolChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("server is running...");
        ExecutorService threadPool = Executors.newCachedThreadPool();
        while (true){
            Socket accept = serverSocket.accept();
            Runnable runnable = () ->{
                InputStream inputStream = null;
                byte[] bytes = new byte[1024];
                try {
                    inputStream = accept.getInputStream();
                    while (true) {
                        int read = inputStream.read(bytes);
                        if(read != -1){
                            String info = new String(bytes,0,read,"UTF-8");
                            System.out.println(Thread.currentThread().getName() + "==>"+info);
                            if("r".equals(info)){
                                break;
                            }
                        }else {
                            break;
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(inputStream != null){
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            threadPool.submit(runnable);
        }
    }
}
