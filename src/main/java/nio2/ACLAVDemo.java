package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.AclEntry;
import java.util.List;

public class ACLAVDemo {
    public static void main(String[] args) throws IOException {
        if(args.length != 1){
            System.err.println("usage: java ACLAVDemo path");
            return;
        }
        Path path = Paths.get(args[0]);
        System.out.printf("Owner:%s%n%n", Files.getAttribute(path, "acl:owner"));
        List<AclEntry> aclEntries = (List<AclEntry>)Files.getAttribute(path, "acl:acl");
        for (AclEntry aclEntry : aclEntries) {
            System.out.printf("%s%n%n", aclEntry);
        }
    }
}
