package mySerializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by lixianch on 2018/1/18.
 */
public class DesStudent {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E://student.ser"));
        Student student = (Student)ois.readObject();
        Student student1 = (Student)ois.readObject();
        System.out.println(student == student1);
        System.out.println(student);
    }
}
