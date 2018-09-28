package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by lixianch on 2018/7/18.
 */
public class UserClient {
    public static void main(String[] args) {
        try {
            UserRemote userRemote = (UserRemote)Naming.lookup("rmi://127.0.0.1/userRemote");
            System.out.println(userRemote.getName());
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
