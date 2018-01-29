package generics;

import generics.coffee.Coffee;
import generics.coffee.CoffeeGenerator;
import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by lixianch on 2016/12/11.
 */
public class Generators {
    public static <T> Collection<T> fill(Collection<T> list,Generator<T> gen,Integer size){
        for(int i = 0;i < size; i++){
            list.add(gen.next());
        }
        return list;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffees = Generators.fill(new ArrayList<Coffee>(),new CoffeeGenerator(),5);
        for(Coffee c : coffees){
            System.out.println(c);
        }
        Collection<Integer> collection = Generators.fill(new ArrayList<Integer>(),new Fibonacci(),18);
        for(Integer i : collection){
            System.out.print(i + " ");
        }
    }
}
