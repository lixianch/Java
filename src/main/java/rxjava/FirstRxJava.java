package rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.log4j.Log4j;

/**
 * Created by lixianch on 2018/8/14.
 */
@Log4j
public class FirstRxJava {
    public static void main(String[] args) {
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                log.info("currentThreadName:" + Thread.currentThread().getName());
                observableEmitter.onNext(1);
                observableEmitter.onNext(2);
                observableEmitter.onNext(3);
                observableEmitter.onNext(4);
                observableEmitter.onComplete();
            }
        });
        Observer<Integer> observer = new Observer<Integer>() {
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
        };
        observable.subscribe(observer);
    }
}
