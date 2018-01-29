package mySerializable;

import java.io.*;

/**
 * Created by lixianch on 2018/1/18.
 */
public class SerTask {
    public static void main(String[] args) {
        SerTask serTask = new SerTask();
        try {
            serTask.ser();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void ser() throws IOException {
        Task task = new Task();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E://task.ser"));
        oos.writeObject(task);
        oos.close();
    }
}
