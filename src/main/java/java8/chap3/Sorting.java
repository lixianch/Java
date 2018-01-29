package java8.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static java.util.Comparator.comparing;

/**
 * Created by lixianch on 2017/12/6.
 */
public class Sorting {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red")));

        inventory.sort(new AppleComparator());
        System.out.println(inventory);

        inventory.set(1,new Apple(30,"green"));
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        System.out.println(inventory);

        inventory.set(1, new Apple(20, "red"));

        inventory.sort((a,b)->a.getWeight().compareTo(b.getWeight()));
        System.out.println(inventory);

        inventory.set(1, new Apple(10, "red"));
        inventory.sort(comparing(Apple::getWeight));
    }
    public static class Apple {
        private Integer weight = 0;
        private String color = "";

        public Apple(Integer weight, String color){
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
    static class AppleComparator implements Comparator<Apple>{

        @Override
        public int compare(Apple o1, Apple o2) {
            return o1.getWeight().compareTo(o2.getWeight());
        }
    }
}
