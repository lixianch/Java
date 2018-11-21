package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by lixianch on 2018/10/23.
 */
public class HeapByteBufferTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D://input.txt");
        FileChannel inChannel = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("D://output.txt");
        FileChannel outChannel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (inChannel.read(byteBuffer) > -1) {
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        outChannel.close();
        inChannel.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
