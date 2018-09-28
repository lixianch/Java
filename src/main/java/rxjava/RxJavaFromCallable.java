package rxjava;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import lombok.extern.log4j.Log4j;

import java.util.concurrent.Callable;

/**
 * Created by lixianch on 2018/8/14.
 * 这里的 Callable 是 java.util.concurrent 中的 Callable，Callable 和 Runnable 的用法基本一致，只是它会返回一个结果值，这个结果值就是发给观察者的。
 */
@Log4j
public class RxJavaFromCallable {
    public static void main(String[] args) {
        Observable.fromCallable(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                log.info("accept:" + integer);
            }
        });
    }
}
