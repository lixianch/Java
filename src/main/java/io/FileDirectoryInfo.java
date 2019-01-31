package io;

import java.io.File;
import java.util.Date;

/**
 * Created by lixianch on 2019/1/31.
 */
public class FileDirectoryInfo {
    public static void main(String[] args) {
        if(args.length != 1){
            System.err.println("Usage: java FileDirectoryInfo path");
            return;
        }
        File file = new File(args[0]);
        System.out.println("About " + file + ":");
        System.out.println("Exists: " + file.exists());
        System.out.println("Is directory: " + file.isDirectory());
        System.out.println("Is file: " + file.isFile());
        System.out.println("Is hidden: " + file.isHidden());
        System.out.println("Last modified: " + new Date(file.lastModified()));
        System.out.println("Length: " + file.length());
    }
}
