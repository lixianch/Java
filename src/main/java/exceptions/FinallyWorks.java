package exceptions;

/**
 * Created by lixianch on 2016/11/22.
 */
class ThreeException extends Exception{}
public class FinallyWorks {
    public static void main(String[] args) {
        int count = 0;
        while(true){
            try {
                if(count++ == 0){
                    throw new ThreeException();
                }
                System.out.println("No exception");
            } catch (ThreeException e) {
                System.out.println("ThreeException");
            }finally {
                System.out.println("In finally clause");
                if(count % 2 == 0) break;
            }
        }
    }
}
