package mySerializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by lixianch on 2018/1/18.
 */
public class StudentSer {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E://student.ser"));
        Student student = new Student();
        student.setName("lixianch");
        student.setAge(30);
        student.setSex("男");
        student.setGrade(1);
        student.setScore(99);
        Teacher teacher = new Teacher();
        teacher.setName("teacher1");
        teacher.setAge(40);
        teacher.setSex("女");
        teacher.setCourse("computer");
        student.setTeacher(teacher);
        oos.writeObject(student);
        student.setSex("name2");
        oos.writeObject(student);
        oos.close();
    }
}
