package java8.chap5;

import java8.chap4.Dish;

import java.util.Optional;

/**
 * Created by lixianch on 2017/12/6.
 */
public class Finding {
    public static void main(String[] args) {
        if(isVegetarianFriendlyMenu()){
            System.out.println("Vegetarian friendly");
        }
        System.out.println(isHealthyMenu());
        System.out.println(isHealthyMenu2());
        Optional<Dish> dish = findVegetarianDish();
        dish.ifPresent((a)-> System.out.println(a.getName()));
    }

    private static boolean isVegetarianFriendlyMenu(){
        return Dish.menu.stream().allMatch(Dish::isVegetarian);
    }

    private static boolean isHealthyMenu(){
        return Dish.menu.stream().allMatch((a)->a.getCalories() < 1000);
    }
    private static boolean isHealthyMenu2(){
        return Dish.menu.stream().noneMatch((a)->a.getCalories() >= 1000);
    }

    private static Optional<Dish> findVegetarianDish(){
        return Dish.menu.stream().filter(Dish::isVegetarian).findAny();
    }
}
