package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by lixianch on 2018/1/29.
 */
public class DirList {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            FilenameFilter filenameFilter = (dir, name) -> {
                Matcher matcher = Pattern.compile(args[0]).matcher(name);
                return matcher.matches();
            };
            list = path.list(filenameFilter);
            Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        }
        String str = Arrays.stream(list).collect(Collectors.joining(","));
        System.out.println(str);
    }
}
