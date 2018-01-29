package mySerializable;

import java.io.Serializable;

/**
 * Created by lixianch on 2018/1/18.
 */
public class Teacher extends Person implements Serializable {
    private static final long serialVersionUID = -5938563711557530379L;
    private String course = "default";

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
