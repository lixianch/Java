package generics.coffee;

import net.mindview.util.Generator;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by lixianch on 2016/12/11.
 */
public class CoffeeGenerator implements Generator<Coffee>,Iterable<Coffee> {
    private Class[] types = {Americano.class,Breve.class,Cappuccino.class,Latte.class,Mocha.class};
    private static Random random = new Random(47);
    private int sz = 0;
    public CoffeeGenerator(){}
    public CoffeeGenerator(int sz){
        this.sz = sz;
    }
    @Override
    public Coffee next() {
        try {
            return (Coffee)types[random.nextInt(types.length)].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    class CoffeeIterator implements Iterator<Coffee>{
        int count = sz;
        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }
    }
    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator cg = new CoffeeGenerator();
        for(int i = 0; i < 5; i++){
            System.out.println(cg.next());
        }
        for(Coffee coffee : new CoffeeGenerator(5)){
            System.out.println(coffee);
        }
    }
}
