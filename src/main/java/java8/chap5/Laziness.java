package java8.chap5;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.*;
/**
 * Created by lixianch on 2017/12/6.
 */
public class Laziness {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> twoEvenSquares = numbers.stream().filter(a -> {
            System.out.println("filtering " + a);
            return a % 2 == 0;
        }).map(a -> {
            System.out.println("Mapping " + a);
            return a * a;
        }).collect(toList());
        twoEvenSquares.forEach(System.out::println);
    }
}
