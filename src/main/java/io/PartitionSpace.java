package io;

import java.io.File;
import java.util.Arrays;

/**
 * Created by lixianch on 2019/1/31.
 */
public class PartitionSpace {
    public static void main(String[] args) {
        File[] files = File.listRoots();
        Arrays.stream(files).forEach(f->{
            System.out.println("Partition: " + f);
            System.out.println("Free space on this partition = " + f.getFreeSpace());
            System.out.println("Usable space on this partition = " + f.getUsableSpace());
            System.out.println("Total space on this partition = " + f.getTotalSpace());
            System.out.println("*********************************************");
        });
    }
}
