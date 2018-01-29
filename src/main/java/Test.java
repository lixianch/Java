import java8.chap4.Dish;

import java.util.List;

/**
 * Created by lixianch on 2018/1/12.
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        try {
            List<Dish> dishList = Dish.menu;
            for (Dish dish : dishList) {
                System.out.println(dish.getName());
                String name = dish.getName();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
