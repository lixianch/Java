package nio2;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class PathDemo1 {
    public static void main(String[] args) {
        FileSystem fsDefault = FileSystems.getDefault();
        Path path = fsDefault.getPath("a", "b", "c");
        System.out.println(path);
        System.out.printf("Absolute:%s%n", path.isAbsolute());
        System.out.printf("Root:%s%n", path.getRoot());
        Iterable<Path> rootDirectories = fsDefault.getRootDirectories();
        for (Path rootDirectory : rootDirectories) {
            path = fsDefault.getPath(rootDirectory.toString(), "a", "b", "c");
            System.out.println(path);
            System.out.printf("Absolute:%s%n", path.isAbsolute());
            System.out.printf("Root:%s%n",path.getRoot());
        }
    }
}
