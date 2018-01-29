package generics;

import java.util.Iterator;

/**
 * Created by lixianch on 2016/12/11.
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private Integer n;
    public IterableFibonacci(Integer n){
        this.n = n;
    }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return IterableFibonacci.this.n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }
        };
    }

    public static void main(String[] args) {
        for(Integer i : new IterableFibonacci(18)){
            System.out.print(i + " ");
        }
    }
}
