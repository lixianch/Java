package io;

import java.io.*;

/**
 * Created by lixianch on 2019/2/1.
 */
public class ExEmployeeSerializationDemo {
    public static final String FILENAME = "exemployee.dat";
    public static void main(String[] args) {
        try(FileOutputStream fos = new FileOutputStream(FILENAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            ExEmployee exEmployee = new ExEmployee("John", 32);
            oos.writeObject(exEmployee);
        }catch (IOException e){
                e.printStackTrace();
        }

        try(FileInputStream fis = new FileInputStream(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            ExEmployee exEmployee = (ExEmployee) ois.readObject();
            System.out.println(exEmployee.getName());
            System.out.println(exEmployee.getAge());
        }catch (ClassNotFoundException e){
                e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
