package designpattern.decorator.starbuzz;

/**
 * Created by lixianch on 2018/8/21.
 */
public class Espresso extends Beverage {
    public Espresso(){
        description = "Espresso";
    }
    @Override
    public double cost() {
        return 1.99;
    }
}
