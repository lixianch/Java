package designpattern.strategy;

/**
 * Created by lixianch on 2018/8/21.
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
