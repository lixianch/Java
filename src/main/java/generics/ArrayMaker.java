package generics;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by lixianch on 2016/12/12.
 */
public class ArrayMaker<T> {
    private Class<T> type;
    public ArrayMaker(Class<T> type){
        this.type = type;
    }

    T[] create(int sz){
        return (T[]) Array.newInstance(type,sz);
    }

    public static void main(String[] args) {
        ArrayMaker<String> am = new ArrayMaker<String>(String.class);
        String[] ss = am.create(9);
        System.out.println(Arrays.toString(ss));
    }
}
