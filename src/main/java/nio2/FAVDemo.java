package nio2;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class FAVDemo {
    public static void main(String[] args) {
        FileSystem fsDefault = FileSystems.getDefault();
        for (String s : fsDefault.supportedFileAttributeViews()) {
            System.out.println(s);
        }
    }
}
