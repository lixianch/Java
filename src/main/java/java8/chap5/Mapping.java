package java8.chap5;

import java8.chap4.Dish;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.*;

/**
 * Created by lixianch on 2017/12/6.
 */
public class Mapping {
    public static void main(String[] args) {
        List<String> dishNames= Dish.menu.stream().map(Dish::getName).collect(toList());
        System.out.println(dishNames);

        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream().map(String::length).collect(toList());
        System.out.println(wordLengths);

        words.stream().flatMap((a)->Arrays.stream(a.split(""))).distinct().forEach(System.out::println);

        List<Integer> numbers1 = Arrays.asList(1,2,3,4,5);
        List<Integer> numbers2 = Arrays.asList(6,7,8);
        List<int[]> pairs = numbers1.stream().flatMap((i)->numbers2.stream().map((j)->new int[]{i,j})).filter(pair->((pair[0]+pair[1])%3 == 0)).collect(toList());
        pairs.forEach(pair-> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));

    }
}
