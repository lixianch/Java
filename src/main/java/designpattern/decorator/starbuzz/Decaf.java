package designpattern.decorator.starbuzz;

/**
 * Created by lixianch on 2018/8/21.
 */
public class Decaf extends Beverage {
    public Decaf(){
        description = "Decaf Coffee";
    }
    @Override
    public double cost() {
        return 1.05;
    }
}
