package designpattern.strategy;

/**
 * Created by lixianch on 2018/8/21.
 */
public class MallardDuck extends Duck {
    public MallardDuck() {
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new Quack());
    }
    @Override
    void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
