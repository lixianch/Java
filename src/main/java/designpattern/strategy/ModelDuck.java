package designpattern.strategy;

/**
 * Created by lixianch on 2018/8/21.
 */
public class ModelDuck extends Duck {
    public ModelDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new Quack());
    }
    @Override
    void display() {
        System.out.println("I'm a model duck");
    }
}
