package generics;

/**
 * Created by lixianch on 2016/12/12.
 */
public class ReturnGenericType<T extends HasF> {
    private T obj;
    public ReturnGenericType(T obj){
        this.obj = obj;
    }
    public T get(){
        return obj;
    }
}
