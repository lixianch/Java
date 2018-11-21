package pb.example1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static pb.example1.AddressBookProto.*;
/**
 * Created by lixianch on 2018/11/6.
 */
public class ListPeopleTest {
    public static void main(String[] args) throws IOException {
        if(args.length < 1){
            System.err.println("Usage:  ListPeople ADDRESS_BOOK_FILE");
            System.exit(-1);
        }
        AddressBook addressBook = AddressBook.parseFrom(new FileInputStream(args[0]));
        Print(addressBook);
    }

    private static void Print(AddressBook addressBook) {
        for (Person person : addressBook.getPeopleList()) {
            System.out.println("Id: " + person.getId());
            System.out.println("Person Name: " + person.getName());
            System.out.println("Email: " + person.getEmail());
            for (Person.PhoneNumber phoneNumber : person.getPhonesList()) {
                switch (phoneNumber.getType()){
                    case HOME:
                        System.out.print("Home Phone: " );
                        break;
                    case WORK:
                        System.out.print("Work Phone: ");
                        break;
                    case MOBILE:
                        System.out.print("Mobile Phone: ");
                        break;
                }
                System.out.println(phoneNumber.getNum());
            }
        }
    }
}
