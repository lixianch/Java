package io;

import java.io.File;

/**
 * Created by lixianch on 2019/1/31.
 */
public class Permissions {
    public static void main(String[] args) {
        if(args.length != 1){
            System.err.println("Usable: java Permissions filespec");
            return;
        }
        File file = new File(args[0]);
        System.out.println("Checking permissions for " + args[0]);
        System.out.println("Execute = " + file.canExecute());
        System.out.println("Write = " + file.canWrite());
        System.out.println("Execute = " + file.canExecute());
    }
}
