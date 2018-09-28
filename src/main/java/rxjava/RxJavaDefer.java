package rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.Data;
import lombok.extern.log4j.Log4j;

import java.util.concurrent.Callable;

/**
 * Created by lixianch on 2018/8/14.
 * 这个方法的作用就是直到被观察者被订阅后才会创建被观察者。
 * 因为 defer() 只有观察者订阅的时候才会创建新的被观察者，所以每订阅一次就会打印一次，并且都是打印 name 最新的值。
 */
@Log4j
public class RxJavaDefer {
    public static void main(String[] args) {
        final User user = new User();
        user.setName("li");
        Observable<User> defer = Observable.defer(new Callable<ObservableSource<User>>() {
            @Override
            public ObservableSource<User> call() throws Exception {
                return Observable.just(user);
            }
        });
        user.setName("xian");
        Observer<User> observer = new Observer<User>() {
            @Override
            public void onSubscribe(Disposable d) {
                log.info("onSubscribe...");
            }

            @Override
            public void onNext(User user) {
                log.info("onNext:" + user);
            }

            @Override
            public void onError(Throwable e) {
                log.info("onError...");
            }

            @Override
            public void onComplete() {
                log.info("onComplete...");
            }
        };
        defer.subscribe(observer);
        user.setName("chang");
        defer.subscribe(observer);
    }

}

@Data
class User {
    private String name;
}
