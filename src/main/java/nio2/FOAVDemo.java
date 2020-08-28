package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;

public class FOAVDemo {
    public static void main(String[] args) throws IOException {
        if(args.length != 1){
            System.err.println("usage: java FOAVDemo path");
            return;
        }
        Path path = Paths.get(args[0]);
        System.out.printf("Owner:%s%n", Files.getOwner(path));
        UserPrincipal userPrincipal = path.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("71871");
        System.out.println(userPrincipal);
        Files.setOwner(path, userPrincipal);
        System.out.printf("File owner:%s%n",Files.getOwner(path));
    }
}
