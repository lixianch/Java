package string;

import generics.coffee.Coffee;
import generics.coffee.Mocha;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixianch on 2017/9/30.
 */
public class WhitherStringBuilder {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("AB");
        List<? super Coffee> list2 = new ArrayList<Coffee>();
        Mocha mocha = new Mocha();
        list2.add(mocha);
        System.out.println(list.getClass() == list2.getClass());
    }
}
