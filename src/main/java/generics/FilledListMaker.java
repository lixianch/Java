package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixianch on 2016/12/12.
 */
public class FilledListMaker<T> {
    List<T> create(T t,int size){
        List<T> result = new ArrayList<T>();
        for(int i = 0; i < size; i++){
            result.add(t);
        }

        return result;
    }

    public static void main(String[] args) {
        FilledListMaker<Integer> flm = new FilledListMaker<Integer>();
        List<Integer> list = flm.create(4,12);
        System.out.println(list);
    }
}
