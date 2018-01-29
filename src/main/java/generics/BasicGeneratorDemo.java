package generics;

import net.mindview.util.Generator;

/**
 * Created by lixianch on 2016/12/11.
 */
public class BasicGeneratorDemo {
    public static void main(String[] args) {
        Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
        for(int i = 0; i < 5; i++){
            System.out.println(gen.next());
        }
    }
}
