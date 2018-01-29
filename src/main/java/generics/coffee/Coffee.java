package generics.coffee;

/**
 * Created by lixianch on 2016/12/11.
 */
public class Coffee {
    private static long counter;
    private final long id = counter++;
    public String toString(){
        return getClass().getSimpleName() + " " + id;
    }
}
