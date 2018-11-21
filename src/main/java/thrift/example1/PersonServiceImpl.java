package thrift.example1;

import org.apache.thrift.TException;

/**
 * Created by lixianch on 2018/11/8.
 */
public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person queryPerson(short id) throws TException {
        Person person = new Person();
        person.setName("lixianch");
        person.setAge((short)30);
        person.setSex("男");
        return person;
    }
}
