package generics;

import typeinfo.pets.Person;
import typeinfo.pets.Pet;

import java.util.Map;

/**
 * Created by lixianch on 2016/12/11.
 */
public class ExplicitTypeSpecification {
    static void f(Map<Person,Pet> map){}

    public static void main(String[] args) {
        f(New.<Person,Pet>map());
    }
}
