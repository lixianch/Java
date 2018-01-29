package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixianch on 2016/12/12.
 */
public class ListMaker<T> {
    public List<T> create(){
        return new ArrayList<T>();
    }

    public static void main(String[] args) {
        ListMaker<String> lm = new ListMaker<String>();
        List<String> list = lm.create();
        System.out.println(list);
    }
}
