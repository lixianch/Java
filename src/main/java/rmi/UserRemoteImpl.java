package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by lixianch on 2018/7/18.
 */
public class UserRemoteImpl extends UnicastRemoteObject implements UserRemote {
    public UserRemoteImpl() throws RemoteException{}
    @Override
    public String getName() throws RemoteException {
        return "lixianch";
    }

    public static void main(String[] args) {
        try {
            UserRemote userRemote = new UserRemoteImpl();
            Naming.bind("userRemote",userRemote);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
