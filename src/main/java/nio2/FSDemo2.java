package nio2;

import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class FSDemo2 {
    public static void main(String[] args) {
        FileSystem fsDefault = FileSystems.getDefault();
        for (FileStore fileStore : fsDefault.getFileStores()) {
            System.out.printf("Filestore:%s%n",fileStore);
        }
    }
}
