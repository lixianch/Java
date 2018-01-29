package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixianch on 2016/12/11.
 */
public class GenericVarargs {
    public static <T> List<T> makeList(T... args){
        List<T> list = new ArrayList<T>();
        for(T t : args){
            list.add(t);
        }

        return list;
    }

    public static void main(String[] args) {
        List<String> list = GenericVarargs.makeList("A");
        System.out.println(list);
        list = GenericVarargs.makeList("A","B","C");
        System.out.println(list);
        list = GenericVarargs.makeList("ABCDEFFHIJKLMNOPQRSTUVWXYZ".split(""));
        System.out.println(list);
    }
}
