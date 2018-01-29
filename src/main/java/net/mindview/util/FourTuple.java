package net.mindview.util;

/**
 * Created by lixianch on 2016/12/11.
 */
public class FourTuple<A,B,C,D> extends ThreeTuple<A,B,C> {
    public final D d;
    public FourTuple(A a,B b,C c,D d){
        super(a,b,c);
        this.d = d;
    }
    public String toString(){
        return "("+a+", "+b+", "+c+", "+d+")";
    }
}
