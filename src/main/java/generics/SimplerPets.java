package generics;

import typeinfo.pets.Person;
import typeinfo.pets.Pet;

import java.util.List;
import java.util.Map;

/**
 * Created by lixianch on 2016/12/11.
 */
public class SimplerPets {
    public static void main(String[] args) {
        Map<Person,List<? extends Pet>> pets = New.map();
    }
}
