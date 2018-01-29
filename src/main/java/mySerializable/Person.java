package mySerializable;

import java.io.Serializable;

/**
 * Created by lixianch on 2018/1/18.
 */
public class Person implements Serializable{
    private static final long serialVersionUID = 3070762162729986228L;
    private String name = "";
    private String sex = "无性别";
    private Integer age = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
