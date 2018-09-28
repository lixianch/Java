package rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.log4j.Log4j;

import java.util.concurrent.TimeUnit;

/**
 * Created by lixianch on 2018/8/14.
 * 可以指定发送事件的开始值和数量，其他与 interval() 的功能一样。
 */
@Log4j
public class RxJavaIntervalRange {
    public static void main(String[] args) {
        Observable.intervalRange(2,3,1,10, TimeUnit.SECONDS).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                log.info("onSubscribe...");
            }

            @Override
            public void onNext(Long aLong) {
                log.info("onNext:" + aLong);
            }

            @Override
            public void onError(Throwable e) {
                log.info("onError...");
            }

            @Override
            public void onComplete() {
                log.info("onComplete...");
            }
        });
    }
}
