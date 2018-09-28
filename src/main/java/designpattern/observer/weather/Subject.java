package designpattern.observer.weather;

/**
 * Created by lixianch on 2018/8/21.
 */
public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}
