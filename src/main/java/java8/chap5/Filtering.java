package java8.chap5;

import java8.chap4.Dish;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.*;

/**
 * Created by lixianch on 2017/12/6.
 */
public class Filtering {
    public static void main(String[] args) {
        List<Dish> vegetarianMenu = Dish.menu.stream().filter(Dish::isVegetarian).collect(toList());
        vegetarianMenu.forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().filter((a)->a%2==0).distinct().forEach(System.out::println);
        System.out.println("-------------");

        List<Dish> dishesLimit3 = Dish.menu.stream().filter((a)->a.getCalories()>300).limit(3).collect(toList());
        dishesLimit3.forEach(System.out::println);
        System.out.println("-------------");

        List<Dish> dishesSkip2 = Dish.menu.stream().filter((a)->a.getCalories()> 300).skip(2).collect(toList());
        dishesSkip2.forEach(System.out::println);
    }
}
