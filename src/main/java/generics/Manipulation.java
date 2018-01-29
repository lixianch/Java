package generics;

/**
 * Created by lixianch on 2016/12/12.
 */
class Manipulator<T>{
    private T obj;
    public Manipulator(T obj){
        this.obj = obj;
    }
    public void manipulate(){
        //Compile Error
//        obj.f();
    }
}
public class Manipulation {
    public static void main(String[] args) {
        HasF h = new HasF();
        Manipulator manipulator = new Manipulator(h);
        manipulator.manipulate();
    }
}
