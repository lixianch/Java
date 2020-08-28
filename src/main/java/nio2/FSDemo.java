package nio2;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FSDemo {
    public static void main(String[] args) throws IOException {
        if(args.length != 1){
            System.err.println("Usage:java FSDemo path");
            return;
        }
        FileStore fileStore = Files.getFileStore(Paths.get(args[0]));
        System.out.printf("Total space:%d%n", fileStore.getTotalSpace());
        System.out.printf("Unallocated space:%d%n", fileStore.getUnallocatedSpace());
        System.out.printf("Usable space:%d%n", fileStore.getUsableSpace());
        System.out.printf("Readonly:%b%n", fileStore.isReadOnly());
        System.out.printf("Type:%s%n", fileStore.type());
        System.out.printf("Name:%s%n", fileStore.name());
    }
}
