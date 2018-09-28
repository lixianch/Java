package designpattern.strategy;

/**
 * Created by lixianch on 2018/8/21.
 */
public class RubberDuck extends Duck {
    public RubberDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new Squeak());
    }
    @Override
    void display() {
        System.out.println("I'm a rubber duckie");
    }
}
