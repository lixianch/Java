package designpattern.decorator.starbuzz;

/**
 * Created by lixianch on 2018/8/21.
 */
public class Milk extends CondimentDecorator {
    private Beverage beverage;
    public Milk(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription() + ".Milk";
    }

    @Override
    public double cost() {
        return .10 + beverage.cost();
    }
}
