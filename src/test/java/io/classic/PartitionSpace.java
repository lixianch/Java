package io.classic;

import io.Obj;
import org.junit.Test;

import java.io.File;

/**
 * Created by lixianch on 2019/1/15.
 */
public class PartitionSpace {
    @Test
    public void printPartionSpace() {
        File[] files = File.listRoots();
        for (File file : files) {
            System.out.println("Partition:" + file);
            System.out.println("Free space on this partition:" + file.getFreeSpace());
            System.out.println("Usable space on this partion:" + file.getUsableSpace());
            System.out.println("Total space on this partition:" + file.getTotalSpace());
            System.out.println("==========================================================");
        }
    }

    @Test
    public void testStr() {
        Obj<Object> d = new Obj<>();
        d.setCode("0000");
        d.setData("String");
        String f = (String)d.getData();
        System.out.println(f);
//        double v = Double.parseDouble(String.valueOf(s));
    }
}
