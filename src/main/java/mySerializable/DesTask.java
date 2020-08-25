package mySerializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by lixianch on 2018/1/18.
 */
public class DesTask {
    public void des() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E://task.ser"));
        Task task = (Task) ois.readObject();
        System.out.println(task.a);
        new Thread(task).start();
    }

    public static void main(String[] args) {
        DesTask desTask = new DesTask();
        try {
            desTask.des();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
