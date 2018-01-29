package bigdata.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lixianch on 2018/1/17.
 */
public class ServiceServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("Server is running......");
        ExecutorService threadPool = Executors.newCachedThreadPool();
        while (true) {
            Socket socket = serverSocket.accept();
            Runnable runnable = () -> {
                InputStream inputStream = null;
                OutputStream outputStream = null;
                PrintWriter printWriter = null;
                BufferedReader br = null;
                try {
                    inputStream = socket.getInputStream();
                    outputStream = socket.getOutputStream();
                    while (true) {
                        br = new BufferedReader(new InputStreamReader(inputStream));
                        String s = br.readLine();
                        if (s != null && !"".equals(s)) {
                            GetDataService getDataService = new GetDataService();
                            String data = getDataService.getData(s);
                            printWriter = new PrintWriter(new OutputStreamWriter(outputStream));
                            printWriter.println(data);
                            printWriter.flush();
                        } else {
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (printWriter != null) {
                        printWriter.close();
                    }
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if(outputStream != null){
                        try {
                            outputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (socket != null) {
                        try {
                            socket.close();
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
