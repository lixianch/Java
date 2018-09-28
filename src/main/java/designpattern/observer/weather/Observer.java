package designpattern.observer.weather;

/**
 * Created by lixianch on 2018/8/21.
 */
public interface Observer {
    public void update(float temp, float humidity, float pressure);
}
