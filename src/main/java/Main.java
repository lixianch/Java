import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("200");
        list.add("300");
        System.out.println(list);
        String l = new Integer(100).toString();
        System.out.println(l);
        System.out.println(list.contains(200L));
        System.out.println(list.contains(300L));
    }
}
