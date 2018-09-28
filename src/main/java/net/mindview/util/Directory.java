package net.mindview.util;

import com.google.common.collect.Lists;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lixianch on 2018/1/29.
 */
public class Directory {
    public static File[] local(File file, String regex) {
        FileFilter fileFilter = (pathname) -> {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(pathname.getName());
            return matcher.matches();
        };

        return file.listFiles(fileFilter);
    }

    public static File[] local(String name, String regex) {
        return local(new File(name), regex);
    }

    public static TreeInfo walk(String file, String regex) {
        return walk(new File(file), regex);
    }

    public static TreeInfo walk(File file, String regex) {
        return recursiveDirs(file, regex);
    }

    public static TreeInfo walk(File file){
        return recursiveDirs(file,".*");
    }

    public static TreeInfo walk(String s){
        return walk(new File(s));
    }

    public static TreeInfo recursiveDirs(File file, String regex) {
        TreeInfo result = new TreeInfo();
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                result.dirs.add(f);
                result.addAll(recursiveDirs(f, regex));
            } else {
                result.files.add(f);
            }
        }

        return result;
    }

    public static class TreeInfo implements Iterable<File> {
        public List<File> files = Lists.newArrayList();
        public List<File> dirs = Lists.newArrayList();

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        public String toString() {
            return "dirs: " + PPrint.pformat(dirs) +
                    "\n\nfiles: " + PPrint.pformat(files);
        }
    }

    public static void main(String[] args) {
        if(args.length == 0){
            TreeInfo treeInfo = walk(new File("."));
            System.out.println(treeInfo);
        }else {
            for(String s : args){
                System.out.println(walk(new File(s)));
            }
        }
    }
}
