package designpattern.decorator.starbuzz;

/**
 * Created by lixianch on 2018/8/21.
 */
public abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
