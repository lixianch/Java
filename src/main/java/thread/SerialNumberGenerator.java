package thread;

/**
 * Created by lixianch on 2016/11/10.
 */
public class SerialNumberGenerator {
    private volatile static int serialNumber = 0;
    public static int nextSerailNumber(){
        return ++serialNumber;
    }
}
