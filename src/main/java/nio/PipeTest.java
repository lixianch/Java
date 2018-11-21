package nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Pipe;
import java.nio.charset.Charset;

/**
 * Created by lixianch on 2018/10/23.
 */
public class PipeTest {
    public static void main(String[] args) throws IOException {
        Pipe pipe = Pipe.open();
        Pipe.SinkChannel sink = pipe.sink();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("Hello World".getBytes());
        byteBuffer.flip();
        sink.write(byteBuffer);
        byteBuffer.clear();
        sink.close();
        Pipe.SourceChannel source = pipe.source();
        CharBuffer charBuffer = null;
        Charset charset = Charset.forName("UTF-8");
        long count = source.read(byteBuffer);
        while (count > -1){
            if(byteBuffer.hasRemaining()){
                byteBuffer.flip();
                charBuffer = charset.decode(byteBuffer);
                System.out.println(charBuffer.toString());
            }
            byteBuffer.clear();
            count = source.read(byteBuffer);
        }
        source.close();
    }
}
