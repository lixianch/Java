package io;

import java.io.File;
import java.util.Arrays;

/**
 * Created by lixianch on 2019/1/31.
 */
public class DumpRoots {
    public static void main(String[] args) {
        File[] files = File.listRoots();
        Arrays.stream(files).forEach(System.out::println);
    }
}
