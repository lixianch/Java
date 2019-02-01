package io;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by lixianch on 2019/2/1.
 */
public class ExEmployee implements Externalizable {
    private String name;
    private Integer age;
    public ExEmployee(){
        System.out.println("ExEmployee called");
    }

    public ExEmployee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("writeExternal called");
        out.writeUTF(name);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("readExternal called");
        name = in.readUTF();
        age = in.readInt();
    }
}
