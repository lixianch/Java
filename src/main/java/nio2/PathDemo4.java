package nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo4 {
    public static void main(String[] args) throws Exception {
        Path path1 = Paths.get("a", "b", "c");
        Path path2 = Paths.get("a", "b", "c", "d");
        System.out.printf("Path1:%s%n", path1);
        System.out.printf("Path2:%s%n", path2);
        System.out.printf("path1.equals(path2):%s%n", path1.equals(path2));
        System.out.printf("path1.equals(path2.subpath(0,3):%s%n", path1.equals(path2.subpath(0, 3)));
        System.out.printf("path1.compareTo(path2):%s%n", path1.compareTo(path2));
        System.out.printf("path1.startWith(\"x\"):%s%n", path1.startsWith("x"));
        System.out.printf("path1.startWith(Paths.get(\"a\")):%s%n", path1.startsWith(Paths.get("a")));
        System.out.printf("path1.endWith(\"d\"):%s%n", path1.endsWith("d"));
        System.out.printf("path1.endWith(Paths.get(\"c\",\"d\"))):%s%n", path1.endsWith(Paths.get("c", "d")));
        System.out.printf("path2.toUri():%s%n", path2.toUri());
        Path path3 = Paths.get(".");
        System.out.printf("path3:%s%n", path3);
        System.out.printf("path3.toRealPath():%s%n",path3.toRealPath());
    }
}
