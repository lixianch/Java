import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java8.chap4.Dish;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * Created by lixianch on 2018/1/12.
 */
public class Test {
    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }
//        try {
//            List<Dish> dishList = Dish.menu;
//            for (Dish dish : dishList) {
//                System.out.println(dish.getName());
//                String name = dish.getName();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        List<Map<String, Object>> stockInfos = Lists.newArrayList();
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("999", 444);
//
//        stockInfos.add(map);
//        System.out.println(stockInfos);
        Method[] d1 = Map.class.getDeclaredMethods();
//        for (Method declaredMethod : declaredMethods) {
//
//            System.out.println(declaredMethod);
//        }
        Method[] d2 = Map.class.getDeclaredMethods();
        System.out.println(d1[0]);
        System.out.println(d2[0]);

        System.out.println(d1[0] == d2[0]);
    }

}
