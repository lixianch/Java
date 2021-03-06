package nio2;

import org.aspectj.apache.bcel.classfile.SourceFile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;

public class FAVDemo1 {
    public static void main(String[] args) {
        System.out.printf("Supports basic:%b%n",isSupported(BasicFileAttributeView.class));
        System.out.printf("Supports posix:%b%n", isSupported(PosixFileAttributeView.class));
        System.out.printf("Supports acl:%b%n",isSupported(AclFileAttributeView.class));
    }

    public static boolean isSupported(Class<? extends FileAttributeView> classZ){
        return Files.getFileAttributeView(Paths.get("."),classZ) == null ? false : true;
    }
}
