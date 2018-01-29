package generics;

import typeinfo.pets.Person;
import typeinfo.pets.Pet;

import java.util.Map;

/**
 * Created by lixianch on 2016/12/11.
 */
public class LimitsOfInference {
    static void f(Map<Person,? extends Pet> petPerson){}

    public static void main(String[] args) {
//        f(New.map());
    }
}
