package holding;

import java.util.Arrays;

/**
 * Created by lixianch on 2016/11/30.
 */
public class ArrayIsNotIterable {
    static <T> void test(Iterable<T> it){
        for(T t : it){
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        test(Arrays.asList(1,2,3,4,5));
        String[] strings = {"A","B","C"};
        // An array works in foreach, but it's not Iterable:
        //!test(strings);
        // You must explicitly convert it to an Iterable:
        test(Arrays.asList(strings));
    }
}
