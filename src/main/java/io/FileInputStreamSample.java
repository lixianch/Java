package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by lixianch on 2019/1/22.
 */
public class FileInputStreamSample {
    public static void main(String[] args) throws Exception{
        System.out.println(System.getProperty("user.home"));
        Arrays.stream(new File(System.getProperty("user.home")).listFiles()).forEach(f-> {
            try {
                System.out.println(f.getCanonicalPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println(System.getProperty("file.separator"));
        File file = new File("E:\\Doc\\dmall.txt");
        System.out.println(file.getPath());
        System.out.println(file.canExecute());
        FileInputStream in1 = new FileInputStream(file);
        FileInputStream in2 = new FileInputStream("E:\\1_800x800L.jpg");
    }

}
