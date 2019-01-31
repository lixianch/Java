package io;

import java.io.File;

/**
 * Created by lixianch on 2019/1/31.
 */
public class PathInfo {
    public static void main(String[] args) throws Exception {
        if(args.length != 1){
            System.err.println("Usage: java PathInfo path");
            return;
        }
        File file = new File(args[0]);
        System.out.println("Absolute path:" + file.getAbsolutePath());
        System.out.println("Canonical path:" + file.getCanonicalPath());
        System.out.println("Name:" + file.getName());
        System.out.println("Path:" + file.getPath());
        System.out.println("Parent:" + file.getParent());
        System.out.println("Is absolute:" + file.isAbsolute());
    }
}
