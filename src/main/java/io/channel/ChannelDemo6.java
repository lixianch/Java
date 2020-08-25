package io.channel;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Created by lixianch on 2019/2/11.
 */
public class ChannelDemo6 {
    public static void main(String[] args) throws IOException {
        if(args.length != 1){
            System.err.println("Usable: ChannelDemo6 filespec");
            return;
        }
        try(FileInputStream fis = new FileInputStream(args[0])){
            FileChannel channel = fis.getChannel();
            WritableByteChannel writableByteChannel = Channels.newChannel(System.out);
            channel.transferTo(0, channel.size(), writableByteChannel);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
