package mySerializable;

import java.io.*;

/**
 * Created by lixianch on 2018/1/18.
 */
public class Student extends Person implements Serializable{
    private static final long serialVersionUID = 4923751524339022882L;
    private Integer score = 0;
    private static Integer money;
    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public static Integer getMoney() {
        return money;
    }

    public static void setMoney(Integer money) {
        Student.money = money;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    private Integer grade;

    private void writeObject(ObjectOutputStream oos){
        try {
            ObjectOutputStream.PutField putField = oos.putFields();
            putField.put("score","**");
            System.out.println("加密得分");
            oos.writeFields();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void readObject(ObjectInputStream ois){
        try {
            ObjectInputStream.GetField getField = ois.readFields();
            Object scoreencr = getField.get("score", "");
            System.out.println("解密前得分：" + scoreencr);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
