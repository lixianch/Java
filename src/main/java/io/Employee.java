package io;

import java.io.Serializable;

/**
 * Created by lixianch on 2019/2/1.
 */
public class Employee implements Serializable{
    private static final long serialVersionUID = 4154705816002947461L;
    private String name;
    private Integer age;

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
