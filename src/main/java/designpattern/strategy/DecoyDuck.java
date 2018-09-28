package designpattern.strategy;

/**
 * Created by lixianch on 2018/8/21.
 */
public class DecoyDuck extends Duck {
    public DecoyDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new MuteQuack());
    }
    @Override
    void display() {
        System.out.println("I'm a duck Decoy");
    }
}
