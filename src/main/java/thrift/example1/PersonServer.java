package thrift.example1;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by lixianch on 2018/11/8.
 */
public class PersonServer {
    public static void main(String[] args) throws TTransportException {
        PersonServer server = new PersonServer();
        server.startServer();
    }

    public void startServer() throws TTransportException {
        TServerTransport transport = new TServerSocket(8090);
        PersonService.Processor<PersonServiceImpl> processor = new PersonService.Processor<PersonServiceImpl>(new PersonServiceImpl());
        TBinaryProtocol.Factory factory = new TBinaryProtocol.Factory(true, true);
        TThreadPoolServer.Args serverArgs = new TThreadPoolServer.Args(transport);
        serverArgs.processor(processor);
        serverArgs.protocolFactory(factory);
        TThreadPoolServer server = new TThreadPoolServer(serverArgs);
        server.serve();
    }
}
