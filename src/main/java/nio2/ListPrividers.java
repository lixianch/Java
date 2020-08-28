package nio2;

import java.nio.file.spi.FileSystemProvider;
import java.util.List;

public class ListPrividers {
    public static void main(String[] args) {
        List<FileSystemProvider> fileSystemProviders = FileSystemProvider.installedProviders();
        for (FileSystemProvider fileSystemProvider : fileSystemProviders) {
            System.out.println(fileSystemProvider);
        }
    }
}
