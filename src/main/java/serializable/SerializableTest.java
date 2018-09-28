package serializable;

import java.io.*;

/**
 * Created by lixianch on 2018/4/23.
 */
public class SerializableTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("test.out"));
        TestObject testObject = new TestObject();
        objectOutputStream.writeObject(testObject);
        objectOutputStream.flush();
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("test.out"));
        testObject = (TestObject)objectInputStream.readObject();
        System.out.println("Parent Value:"+testObject.parentValue);
        System.out.println("Inner Value:" + testObject.innerObject.innerValue);
        System.out.println("Test Value:" + testObject.testValue);
    }
}

class Parent implements Serializable {
    private static final long serialVersionUID = 276533914439181718L;

    public int parentValue = 100;
}

class InnerObject implements Serializable {
    private static final long serialVersionUID = 5351547789536766210L;

    public int innerValue = 200;
}

class TestObject extends Parent implements Serializable {
    private static final long serialVersionUID = 960745515602554634L;
    public int testValue = 300;
    InnerObject innerObject = new InnerObject();
}
