package io;

import java.io.*;

/**
 * Created by lixianch on 2019/2/1.
 */
public class DataStreamsDemo {
    public static final String FILENAME = "data.dat";
    public static void main(String[] args) {
        try(FileOutputStream fos = new FileOutputStream(FILENAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeInt(1995);
            oos.writeUTF("Saving this String in modified UTF-8 format!");
            oos.writeFloat(1.0f);
        }catch (FileNotFoundException e){
                e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        try(FileInputStream fis = new FileInputStream(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            System.out.println(ois.readInt());
            System.out.println(ois.readUTF());
            System.out.println(ois.readFloat());
        }catch (IOException e){
                e.printStackTrace();
        }
    }
}
