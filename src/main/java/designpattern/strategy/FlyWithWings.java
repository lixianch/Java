package designpattern.strategy;

/**
 * Created by lixianch on 2018/8/21.
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying!!");
    }
}
