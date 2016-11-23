package thread;

/**
 * Created by lixianch on 2016/11/10.
 */
public class Atomicity {
    int i;
    public int f1(){
        return ++i;
    }
    public int f2() {
        return i += 3;
    }
}
