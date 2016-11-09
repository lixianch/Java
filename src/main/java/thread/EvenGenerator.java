package thread;

/**
 * Created by lixianch on 2016/11/9.
 */
public class EvenGenerator extends IntGenerator {
    private int currentValue = 0;
    @Override
    public int next() {
        ++currentValue;
        Thread.yield();
        ++currentValue;
        return currentValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
