package pb.example2;

import java.io.FileOutputStream;
import java.io.IOException;

import static pb.example2.UpdatePerson.*;
/**
 * Created by lixianch on 2018/11/6.
 */
public class UpdatePersonWriteTest {
    public static void main(String[] args) throws IOException {
        if(args.length <= 0){
            System.err.println("Please enter the file!");
            System.exit(-1);
        }
        FileOutputStream out = new FileOutputStream(args[0]);
        Person.Builder person = Person.newBuilder();
        person.setId(3);
//        person.setName("lixianch");
        person.addPhones("18108069484");
        person.addPhones("18628357910");
        person.build().writeTo(out);
    }
}
