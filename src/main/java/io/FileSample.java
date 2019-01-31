package io;

import java.io.File;
import java.io.IOException;

/**
 * Created by lixianch on 2019/1/23.
 */
public class FileSample {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        File file = new File("./pom.xml");
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.exists());
        System.out.println(file.canExecute());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        File f2 = new File(".\\pom.xml");
        System.out.println(file.compareTo(f2));
        try {
            System.out.println(file.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(file.delete());
//        System.out.println(file.deleteOnExit());
        file.listFiles();
        file.getUsableSpace();
//        file.setExecutable()
    }
}
