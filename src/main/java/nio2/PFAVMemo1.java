package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

public class PFAVMemo1 {
    public static void main(String[] args) throws IOException {
        if(args.length < 1|| args.length > 2){
            System.err.println("Usage: java PFAVMemo1 path [group]");
            return;
        }
        Path path = Paths.get(args[0]);
        boolean setAttr = false;
        if(args.length == 2){
            setAttr = true;
        }
        System.out.printf("Group: %s%n", Files.getAttribute(path, "posix:group"));
        Set<PosixFilePermission> permissions = (Set<PosixFilePermission>) Files.getAttribute(path, "posix:permissions");
        for (PosixFilePermission permission : permissions) {
            System.out.printf("Permission:%s%n", permission);
        }
        if(setAttr){
            Files.setAttribute(path, "posix:group", path.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByGroupName(args[1]));
            System.out.printf("Group: %s%n", Files.getAttribute(path, "posix:group"));
        }
    }
}
