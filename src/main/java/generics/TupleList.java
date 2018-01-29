package generics;

import net.mindview.util.FourTuple;

import java.util.ArrayList;

/**
 * Created by lixianch on 2016/12/12.
 */
public class TupleList<A,B,C,D> extends ArrayList<FourTuple<A,B,C,D>> {
    public static void main(String[] args) {
        TupleList<Vehicle,Amphibian,String,Integer> tl = new TupleList<Vehicle, Amphibian, String, Integer>();
        tl.add(TupleTest.h());
        tl.add(TupleTest.h());
        for(FourTuple<Vehicle,Amphibian,String,Integer> t : tl){
            System.out.println(t);
        }
    }
}
