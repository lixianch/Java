package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lixianch on 2016/11/10.
 */
public class AtomicEvenGenerator extends IntGenerator{
    private AtomicInteger v = new AtomicInteger(0);
    @Override
    public int next() {
        return v.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
