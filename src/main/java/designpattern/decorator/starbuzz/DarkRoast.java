package designpattern.decorator.starbuzz;

/**
 * Created by lixianch on 2018/8/21.
 */
public class DarkRoast extends Beverage {
    public DarkRoast(){
        description = "Dark Roast Coffee";
    }
    @Override
    public double cost() {
        return .99;
    }
}
