package io;

import java.io.File;

/**
 * Created by lixianch on 2019/1/31.
 */
public class Compare {
    public static void main(String[] args) throws Exception {
        if(args.length != 2){
            System.out.println("Usable: java Compare filespec1 filespec2");
            return;
        }
        File file1 = new File(args[0]);
        File file2 = new File(args[1]);
        System.out.println(file1.compareTo(file2));
        System.out.println(file1.getCanonicalPath().compareTo(file2.getCanonicalPath()));
    }
}
