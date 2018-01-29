package generics;

/**
 * Created by lixianch on 2016/12/12.
 */
public class SimpleHolder {
    private Object obj;
    public void set(Object obj){
        this.obj = obj;
    }
    public Object get(){
        return obj;
    }

    public static void main(String[] args) {
        SimpleHolder sh = new SimpleHolder();
        sh.set("Item");
        String s = (String)sh.get();
    }
}
