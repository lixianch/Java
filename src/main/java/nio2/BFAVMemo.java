package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;

public class BFAVMemo {
    public static void main(String[] args) throws IOException {
        if(args.length != 1){
            System.err.println("Usage: java BFAVMemo path");
            return;
        }
        Path path = Paths.get(args[0]);
        BasicFileAttributes bfa = Files.readAttributes(path,BasicFileAttributes.class);
        System.out.printf("Creation time:%s%n", bfa.creationTime());
        System.out.printf("File key:%s%n", bfa.fileKey());
        System.out.printf("Is directory:%b%n", bfa.isDirectory());
        System.out.printf("Is other:%b%n", bfa.isOther());
        System.out.printf("Is regular file:%b%n", bfa.isRegularFile());
        System.out.printf("Is symbolic file:%b%n", bfa.isSymbolicLink());
        System.out.printf("Last access time:%s%n", bfa.lastAccessTime());
        System.out.printf("Last modified time:%s%n", bfa.lastModifiedTime());
        System.out.printf("Size:%d%n", bfa.size());
    }
}
