package net.mindview.util;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by lixianch on 2018/1/29.
 */
public class PPrint {
    public static String pformat(Collection<?> c){
        if(c.size() == 0){
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for(Object b : c){
            if(c.size() != 1){
                sb.append("\n ");
            }
            sb.append(b);
        }
        if(c.size() != 1){
            sb.append("\n ");
        }
        sb.append("]");

        return sb.toString();
    }

    public static void pprint(Collection<?> c){
        pformat(c);
    }
    public static void pprint(String[] ss){
        pformat(Arrays.asList(ss));
    }
}
