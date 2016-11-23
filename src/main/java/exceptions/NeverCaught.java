package exceptions;

/**
 * Created by lixianch on 2016/11/22.
 */
public class NeverCaught {
    static void f() {
        throw new RuntimeException("From f()");
    }
    static void g() {
        f();
    }
    public static void main(String[] args) {
        g();
    }
}
