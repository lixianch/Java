package java8.chap4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by lixianch on 2017/12/6.
 */
public class StreamVsCollection {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Java8", "Lambdas", "In", "Action");
        Stream<String> stream = names.stream();
        stream.forEach(System.out::println);
        //流只能被消费一次

//        stream.forEach(System.out::println);
    }
}
