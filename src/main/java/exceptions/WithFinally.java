package exceptions;

/**
 * Created by lixianch on 2016/11/22.
 */
public class WithFinally {
    private static Switch sw = new Switch();
    public static void f() throws OnOffException1,OnOffException2{}

    public static void main(String[] args) {
        try {
            sw.on();
            f();
        } catch (OnOffException1 e) {
            System.out.println("OnOffException1");
        } catch (OnOffException2 e) {
            System.out.println("OnOffException2");
        }finally {
            sw.off();
        }
    }
}
