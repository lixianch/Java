package rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.log4j.Log4j;

import java.util.concurrent.TimeUnit;

/**
 * Created by lixianch on 2018/8/14.
 * 每隔一段时间就会发送一个事件，这个事件是从0开始，不断增1的数字。
 */
@Log4j
public class RxJavaInterval {
    public static void main(String[] args) {
        Observable.interval(2, TimeUnit.SECONDS).subscribe(new Observer<Long>() {
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
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
