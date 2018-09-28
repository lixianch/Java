package rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.log4j.Log4j;

import java.util.concurrent.TimeUnit;

/**
 * Created by lixianch on 2018/8/14.
 * 当到指定时间后就会发送一个 0L 的值给观察者。
 */
@Log4j
public class RxJavaTimer {
    public static void main(String[] args) {
        Observable.timer(10, TimeUnit.SECONDS).subscribe(new Observer<Long>() {
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
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
