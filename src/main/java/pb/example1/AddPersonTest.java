package pb.example1;

import java.io.*;
import static pb.example1.AddressBookProto.*;
/**
 * Created by lixianch on 2018/11/6.
 */
public class AddPersonTest {
    public static void main(String[] args) throws IOException {
        if(args.length != 1){
            System.out.println("Args invalid");
            System.exit(-1);
        }
        AddressBook.Builder addressBook = AddressBook.newBuilder();
        try {
            addressBook.mergeFrom(new FileInputStream(args[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        addressBook.addPeople(PromptForAddress(new BufferedReader(new InputStreamReader(System.in)), System.out));
        FileOutputStream out = new FileOutputStream(args[0]);
        addressBook.build().writeTo(out);
        out.close();
    }

    private static Person PromptForAddress(BufferedReader stdin, PrintStream stdout) throws IOException {
        Person.Builder person = Person.newBuilder();
        stdout.print("Enter person id：");
        person.setId(Integer.valueOf(stdin.readLine()));
        stdout.print("Enter person name：");
        person.setName(stdin.readLine());
        stdout.print("Enter email address (blank for none):");
        String email = stdin.readLine();
        if(email.length() > 0){
            person.setEmail(email);
        }
        while (true){
            stdout.print("Enter a phone number or leave blank to finish:");
            String phone = stdin.readLine();
            if(phone.length() == 0){
                break;
            }
            Person.PhoneNumber.Builder phoneNumber = Person.PhoneNumber.newBuilder();
            phoneNumber.setNum(phone);
            stdout.print("Is this a mobile, home, or work phone? ");
            String type = stdin.readLine();
            if("mobile".equalsIgnoreCase(type)){
                phoneNumber.setType(Person.PhoneType.MOBILE);
            }else if("home".equalsIgnoreCase(type)){
                phoneNumber.setType(Person.PhoneType.HOME);
            }else if("work".equalsIgnoreCase(type)){
                phoneNumber.setType(Person.PhoneType.WORK);
            }else {
                stdout.println("Unknown phone type.  Using default.");
            }
            person.addPhones(phoneNumber);
        }
        return person.build();
    }
}
