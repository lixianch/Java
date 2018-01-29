package holding;

import java.util.ArrayList;

/**
 * Created by lixianch on 2016/11/30.
 */
class Apple {
    private static long counter;
    private final long id = ++counter;
    public long getId(){
        return id;
    }
}
class Orange {}
public class ApplesAndOrangesWithoutGenerics {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        for(int i = 0; i < 3; i++){
            list.add(new Apple());
        }
        list.add(new Orange());
        for(Object obj : list){
            System.out.println(((Apple)obj).getId());
        }
    }
}
