package rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.log4j.Log4j;

/**
 * Created by lixianch on 2018/8/14.
 * 创建一个被观察者
 */
@Log4j
public class RxJavaCreate {
    public static void main(String[] args) {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext("Hello Observable");
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                log.info("onSubscribe...");
            }

            @Override
            public void onNext(String s) {
                log.info("onNext:" + s);
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
