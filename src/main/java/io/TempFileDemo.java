package io;

import java.io.File;

/**
 * Created by lixianch on 2019/1/31.
 */
public class TempFileDemo {
    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperty("java.io.tmpdir"));
        File tempFile = File.createTempFile("text", ".txt");
        System.out.println(tempFile);
        tempFile.deleteOnExit();
    }
}
