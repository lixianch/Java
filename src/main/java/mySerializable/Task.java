package mySerializable;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lixianch on 2018/1/18.
 */
public class Task implements Runnable,Serializable {
    private static final long serialVersionUID = 3642653739637952479L;
    String a;
    @Override
    public void run() {
        System.out.println(new Date());
    }
}
