package concurrency;

import java.util.concurrent.ThreadFactory;

/**
 * Created by lixianch on 2016/9/19.
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
