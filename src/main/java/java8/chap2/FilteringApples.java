package java8.chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lixianch on 2017/12/6.
 */
public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),new Apple(155,"green"),new Apple(120,"red"));

        List<Apple> greenApples = filterApplesByColor(inventory,"green");
        System.out.println(greenApples);

        List<Apple> redApples = filterApplesByColor(inventory,"red");
        System.out.println(redApples);

        List<Apple> greenApples2 = filter(inventory,new AppleColorPredicate());
        System.out.println(greenApples2);

        List<Apple> heavyApples2 = filter(inventory,new AppleWeightPredicate());
        System.out.println(heavyApples2);

        List<Apple> redAndHeavyApples = filter(inventory,new AppleRedAndHeavyPredicate());
        System.out.println(redAndHeavyApples);

        List<Apple> redApples2 = filter(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple a) {
                return "red".equals(a.getColor());
            }
        });
        System.out.println(redApples2);
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if("green".equals(apple.getColor())){
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory,String color){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(color.equals(apple.getColor())){
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> inventory,int weight){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(apple.getWeight() > weight){
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filter(List<Apple> inventory,ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }

        return result;
    }
    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color){
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }

    interface ApplePredicate{
        public boolean test(Apple a);
    }

    static class AppleWeightPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple a) {
            return a.getWeight() > 150;
        }
    }

    static class AppleColorPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple a) {
            return "green".equals(a.getColor());
        }
    }

    static class AppleRedAndHeavyPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple a) {
            return "red".equals(a.getColor()) && a.getWeight() > 150;
        }
    }
}
