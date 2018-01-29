package generics;

import net.mindview.util.Generator;

import java.util.*;

/**
 * Created by lixianch on 2016/12/12.
 */
class Customer {
    private static long counter;
    private final long id = counter++;
    public Customer(){}
    public String toString(){
        return "Customer " + id;
    }
    public static Generator<Customer> generator(){
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }
}

class Teller{
    private static long counter;
    private final long id = counter++;
    public Teller(){}
    public String toString(){
        return "Teller " + id;
    }
    public static Generator<Teller> generator(){
        return new Generator<Teller>() {
            @Override
            public Teller next() {
                return new Teller();
            }
        };
    }
}
public class BankTeller {
    public static void serve(Teller t,Customer c){
        System.out.println(t + " serve " + c);
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        Queue<Customer> line =new LinkedList<Customer>();
        Generators.fill(line,Customer.generator(),18);
        List<Teller> tellers = new ArrayList<Teller>();
        Generators.fill(tellers,Teller.generator(),8);
        for(Customer c : line){
            serve(tellers.get(random.nextInt(tellers.size())),c);
        }
    }
}
