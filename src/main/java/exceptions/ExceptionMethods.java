package exceptions;

/**
 * Created by lixianch on 2016/11/22.
 */
public class ExceptionMethods {
    public static void main(String[] args) {
        try {
            throw new Exception("My Exception");
        } catch (Exception e) {
            System.out.println("Caught Exception");
            System.out.println("getMesssage(): " + e.getMessage());
            System.out.println("getLocalizedMessage(): " + e.getLocalizedMessage());
            System.out.println("toString(): " + e.toString());
            System.out.println("printStackTrace(): ");
            e.printStackTrace();
        }
    }
}
