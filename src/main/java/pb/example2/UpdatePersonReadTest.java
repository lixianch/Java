package pb.example2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static pb.example2.UpdatePerson.*;

/**
 * Created by lixianch on 2018/11/6.
 */
public class UpdatePersonReadTest {
    public static void main(String[] args) throws IOException {
        if(args.length <= 0){
            System.err.println("Please enter the file");
            System.exit(-1);
        }
        FileInputStream in = new FileInputStream(args[0]);
        Person.Builder person = Person.newBuilder();
        person.mergeFrom(in);
        Person p = person.build();
        System.out.println("Id:" + p.getId());
        System.out.println("Login:" + p.getLogin());
        System.out.print("phones:");
        p.getPhonesList().forEach((a)-> System.out.print(a));
        System.out.println();
    }
}
