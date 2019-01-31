package io;

import java.io.Externalizable;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

/**
 * Created by lixianch on 2019/1/31.
 */
public class Dir {
    public static void main(String[] args) {
        if(args.length != 2){
            System.err.println("Usable:java Dir path ext");
            return;
        }
        File file = new File(args[0]);
        FilenameFilter filter = (File dir, String name)->{
            return name.endsWith(args[1]);
        };
        String[] list = file.list(filter);
        Arrays.stream(list).forEach(System.out::println);
    }
}
