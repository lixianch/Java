package thread;

/**
 * Created by lixianch on 2016/11/9.
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();
    public void cancel() {
        this.canceled = true;
    }
    public boolean isCanceled(){
        return canceled;
    }
}
