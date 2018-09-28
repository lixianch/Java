package designpattern.decorator.starbuzz;

/**
 * Created by lixianch on 2018/8/21.
 */
public class Mocha extends CondimentDecorator {
    private Beverage beverage;
    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription() + ".Mocha";
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }
}
