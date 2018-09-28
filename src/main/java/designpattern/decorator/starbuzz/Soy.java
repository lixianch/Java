package designpattern.decorator.starbuzz;

/**
 * Created by lixianch on 2018/8/21.
 */
public class Soy extends CondimentDecorator {
    private Beverage beverage;
    public Soy(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription() + ".Soy";
    }

    @Override
    public double cost() {
        return .15 + beverage.cost();
    }
}
