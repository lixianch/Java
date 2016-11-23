package exceptions;

/**
 * Created by lixianch on 2016/11/22.
 */
class MyException extends Exception {
    public MyException(){}
    public MyException(String msg){
        super(msg);
    }
}
public class FullConstructors {
    public void f() throws MyException{
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }
    public void g() throws MyException {
        System.out.println("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }

    public static void main(String[] args) {
        FullConstructors fc = new FullConstructors();
        try {
            fc.f();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
        try {
            fc.g();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
    }
}
