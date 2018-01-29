package net.mindview.util;

/**
 * Created by lixianch on 2016/12/11.
 */
public class FiveTuple<A,B,C,D,E> extends FourTuple<A,B,C,D> {
    public final E e;
    public FiveTuple(A a,B b,C c,D d,E e){
        super(a,b,c,d);
        this.e = e;
    }
    public String toString(){
        return "("+a+", "+b+", "+c+", "+d+", "+e+")";
    }
}
