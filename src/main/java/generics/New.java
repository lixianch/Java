package generics;

import java.util.*;

/**
 * Created by lixianch on 2016/12/11.
 */
public class New {
    public static <K,V> Map<K,V> map(){
        return new HashMap<K,V>();
    }
    public static <T> List<T> list(){
        return new ArrayList<T>();
    }
    public static <T> LinkedList<T> lList(){
        return new LinkedList<T>();
    }
    public static <T> Set<T> set(){
        return new HashSet<T>();
    }
    public static <T> Queue<T> queue(){
        return new LinkedList<T>();
    }

    public static void main(String[] args) {
        Map<String,List<String>> map = New.map();
        List<Integer> list = New.list();
        LinkedList<Integer> lList = New.lList();
        Set<String> set = New.set();
        Queue<String> queue = New.queue();
    }
}
