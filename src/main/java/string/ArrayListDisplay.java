package string;

import generics.coffee.Coffee;
import generics.coffee.CoffeeGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixianch on 2017/9/22.
 */
public class ArrayListDisplay {
    public static void main(String[] args) {
        List<Coffee> coffees = new ArrayList<Coffee>();
        for(Coffee coffee : new CoffeeGenerator(10)){
            coffees.add(coffee);
        }
        System.out.println(coffees);
    }

}
