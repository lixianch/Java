package io;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by lixianch on 2019/2/1.
 */
public class SerEmployee extends Employee implements Serializable {
    private static final long serialVersionUID = -4316676659700790942L;
    private String sex;
    public SerEmployee(String name, Integer age, String sex) {
        super(name, age);
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }
}
