package generics;

/**
 * Created by lixianch on 2016/12/11.
 */
public class Holder2 {
    private Object a;
    public Holder2(Object a){
        this.a = a;
    }
    public Object get(){
        return a;
    }

    public void set(Object o){
        this.a = o;
    }

    public static void main(String[] args) {
        Holder2 h2 = new Holder2(new Automobile());
        Automobile a = (Automobile)h2.get();
        h2.set("Not an AutoMobile");
        String s = (String)h2.get();
        h2.set(4);
        Integer i = (Integer)h2.get();
    }
}
