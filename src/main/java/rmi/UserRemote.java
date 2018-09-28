package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by lixianch on 2018/7/18.
 */
public interface UserRemote extends Remote {
    public String getName() throws RemoteException;
}
