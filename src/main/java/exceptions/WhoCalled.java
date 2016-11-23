package exceptions;

/**
 * Created by lixianch on 2016/11/22.
 */
public class WhoCalled {
    static void f(){
        try {
            throw new Exception();
        } catch (Exception e) {
            for(StackTraceElement elemt : e.getStackTrace()){
                System.out.println(elemt.getMethodName());
            }
        }
    }
    static void g(){
        f();
    }
    static void h(){
        g();
    }

    public static void main(String[] args) {
        f();
        System.out.println("------------------------------");
        g();
        System.out.println("------------------------------");
        h();
    }
}
