package io;

import java.io.*;

/**
 * Created by lixianch on 2019/2/1.
 */
public class SerializationDemo {
    public static final String FILENAME = "employee.dat";
    public static void main(String[] args) {
        try(FileOutputStream fos = new FileOutputStream(FILENAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            Employee employee = new Employee("Johe Doe", 36);
            oos.writeObject(employee);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try(FileInputStream fis = new FileInputStream(FILENAME);
                ObjectInputStream ois = new ObjectInputStream(fis)
                ){
            Employee employee = (Employee)ois.readObject();
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        }catch (ClassNotFoundException e){
                    e.printStackTrace();
        }catch (IOException e){
                    e.printStackTrace();
        }

    }
}
