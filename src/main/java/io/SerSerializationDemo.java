package io;

import java.io.*;

/**
 * Created by lixianch on 2019/2/1.
 */
public class SerSerializationDemo {
    public static final String FILENAME = "seremployee.dat";

    public static void main(String[] args) {
        try(FileOutputStream fos = new FileOutputStream(FILENAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            SerEmployee serEmployee = new SerEmployee("leo", 30, "male");
            oos.writeObject(serEmployee);
        }catch (IOException e){
            e.printStackTrace();
        }

        try(FileInputStream fis = new FileInputStream(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            SerEmployee serEmployee = (SerEmployee) ois.readObject();
            System.out.println(serEmployee.getName());
            System.out.println(serEmployee.getAge());
            System.out.println(serEmployee.getSex());
        }catch (ClassNotFoundException e){
                e.printStackTrace();
        }catch (IOException e){
                e.printStackTrace();
        }
    }
}
