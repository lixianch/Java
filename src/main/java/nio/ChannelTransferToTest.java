package nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * Created by lixianch on 2018/10/23.
 */
public class ChannelTransferToTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D://input.txt");
        FileChannel inChannel = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("D://copy.txt");
        FileChannel outChannel = fileOutputStream.getChannel();
        long start = 0;
        long end = inChannel.size();
        inChannel.transferTo(start, end, outChannel);
        outChannel.close();
        inChannel.close();
        fileOutputStream.close();
        fileInputStream.close();
    }
}
