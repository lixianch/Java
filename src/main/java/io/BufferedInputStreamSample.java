package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by lixianch on 2019/1/23.
 */
public class BufferedInputStreamSample {
    public static void main(String[] args){
        byte[] bytes = new byte[8084];
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("pom.xml"))) {
            int count = 0;
            count = in.read(bytes, 0, bytes.length);
            while(count > 0){
                System.out.println(new String(bytes,"UTF-8"));
                count = in.read(bytes, 0, bytes.length);
            }
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
