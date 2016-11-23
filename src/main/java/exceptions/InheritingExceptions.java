package exceptions;

/**
 * Created by lixianch on 2016/11/22.
 */
class SimpleException extends Exception{}
public class InheritingExceptions {
    public void f() throws SimpleException{
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }
    public static void main(String[] args) {
        InheritingExceptions sed = new InheritingExceptions();
        try {
            sed.f();
        } catch (SimpleException e) {
            System.out.println("Catch it!");
        }
    }
}
