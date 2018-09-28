package rxjava;

import com.google.common.collect.Lists;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.log4j.Log4j;

import java.util.List;

/**
 * Created by lixianch on 2018/8/14.
 * 直接发送一个 List 集合数据给观察者
 */
@Log4j
public class RxJavaFromIterable {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        Observable.fromIterable(list).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                log.info("onSubscribe...");
            }

            @Override
            public void onNext(Integer integer) {
                log.info("onNext:" + integer);
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
