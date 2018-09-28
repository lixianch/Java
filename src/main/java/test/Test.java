package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 3, 6, 3, 1);
        list.sort((a,b)->{
            return b - a;
        });
        System.out.println(list);
    }
}
