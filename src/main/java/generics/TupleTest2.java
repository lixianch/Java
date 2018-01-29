package generics;

/**
 * Created by lixianch on 2016/12/12.
 */
import net.mindview.util.FiveTuple;
import net.mindview.util.FourTuple;
import net.mindview.util.ThreeTuple;
import net.mindview.util.TwoTuple;

import static net.mindview.util.Tuple.*;

public class TupleTest2 {
    static TwoTuple<String,Integer> f(){
        return tuple("hi",45);
    }
    static TwoTuple f2(){
        return tuple("hi",45);
    }
    static ThreeTuple<Amphibian,String,Integer> g(){
        return tuple(new Amphibian(),"hi",45);
    }
    static FourTuple<Vehicle,Amphibian,String,Integer> h(){
        return tuple(new Vehicle(),new Amphibian(),"hi",45);
    }
    static FiveTuple<Vehicle,Amphibian,String,Integer,Double> k(){
        return tuple(new Vehicle(),new Amphibian(),"hi",45,11.1);
    }

    public static void main(String[] args) {
        TwoTuple<String,Integer> ttis = f();
        System.out.println(ttis);
        System.out.println(f2());
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}
