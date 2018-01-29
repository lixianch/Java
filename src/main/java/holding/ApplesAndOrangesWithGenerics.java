package holding;

import java.util.ArrayList;

/**
 * Created by lixianch on 2016/11/30.
 */
public class ApplesAndOrangesWithGenerics {
    public static void main(String[] args) {
        ArrayList<Apple> list = new ArrayList<Apple>();
        for(int i = 0; i < 3; i++){
            list.add(new Apple());
        }
//        list.add(new Orange());
        for(Apple apple : list){
            System.out.println(apple.getId());
        }
    }
}
