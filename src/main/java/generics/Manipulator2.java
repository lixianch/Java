package generics;

/**
 * Created by lixianch on 2016/12/12.
 */
public class Manipulator2<T extends HasF> {
    private T obj;
    public Manipulator2(T obj){
        this.obj = obj;
    }
    public void manipulate(){
        obj.f();
    }
}
