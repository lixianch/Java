package io;

import net.mindview.util.Directory;
import net.mindview.util.PPrint;

import java.io.File;

/**
 * Created by lixianch on 2018/1/29.
 */
public class DirectoryDemo {
    public static void main(String[] args) {
        PPrint.pprint(Directory.walk(".").dirs);
        for(File f : Directory.walk(".","T.*")){
            System.out.println(f);
        }
        for(File f : Directory.walk(".","T.*\\.java")){
            System.out.println(f);
        }
        for (File file : Directory.walk(".", "[Zz].*\\.class")) {
            System.out.println(file);
        }
    }

}
