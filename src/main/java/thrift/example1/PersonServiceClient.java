package thrift.example1;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Created by lixianch on 2018/11/8.
 */
public class PersonServiceClient {
    public static void main(String[] args) throws TException {
        PersonServiceClient personServiceClient = new PersonServiceClient();
        personServiceClient.startClient();
    }

    public void startClient() throws TException {
        TTransport transport = new TSocket("localhost", 8090);
        TBinaryProtocol protocol = new TBinaryProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);
        transport.open();
        System.out.println(client.queryPerson((short) 2));
        transport.close();
    }
}
