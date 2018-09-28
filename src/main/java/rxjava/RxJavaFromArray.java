package rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.log4j.Log4j;

/**
 * Created by lixianch on 2018/8/14.
 * 这个方法和 just() 类似，只不过 fromArray 可以传入多于10个的变量，并且可以传入一个数组。
 */
@Log4j
public class RxJavaFromArray {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5};
        Observable.fromArray(array).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                log.info("onSubscribe...");
            }

            @Override
            public void onNext(Integer integer) {
                log.info("onNext:" + integer);
            }

            @Override
            public void onError(Throwable throwable) {
                log.info("onError...");
            }

            @Override
            public void onComplete() {
                log.info("onComplete...");
            }
        });
    }
}
