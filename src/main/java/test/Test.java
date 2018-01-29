package test;

import java.util.ArrayList;

/**
 * Created by lixianch on 2018/1/12.
 */
public class Test implements ITest {
    private static final String LOGGER = "logger";

    @Override
    public void test() {
        System.out.println("namejkdfs");
        ArrayList list = new ArrayList();
        if (LOGGER == "11") {
            String var2 = "name";
        }
    }
}
