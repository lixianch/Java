package designpattern.decorator.starbuzz;

/**
 * Created by lixianch on 2018/8/21.
 */
public class Whip extends CondimentDecorator {
    private Beverage beverage;
    public Whip(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription() + ".Whip";
    }

    @Override
    public double cost() {
        return .10 + beverage.cost();
    }
}
