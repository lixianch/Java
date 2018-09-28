package designpattern.strategy;

/**
 * Created by lixianch on 2018/8/21.
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
