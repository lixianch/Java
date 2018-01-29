package generics;

/**
 * Created by lixianch on 2016/12/12.
 */
class GenericBase<T>{
    private T obj;
    public void set(T obj){
        this.obj = obj;
    }
    public T get(){
        return obj;
    }
}

class Derived1<T> extends GenericBase<T>{}
class Derived2 extends GenericBase{}
//class Derived3 extends GenericBase<?>{}
public class ErasureAndInheritance {
    public static void main(String[] args) {
        Derived2 d2 = new Derived2();
        Object obj = d2.get();
        d2.set(obj);
    }
}
