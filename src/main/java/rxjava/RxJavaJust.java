package rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.log4j.Log4j;

/**
 * Created by lixianch on 2018/8/14.
 * 创建一个被观察者，并发送事件，发送的事件不可以超过10个以上
 */
@Log4j
public class RxJavaJust {
    public static void main(String[] args) {
        Observable.just(1,2,3).subscribe(new Observer<Integer>() {
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
