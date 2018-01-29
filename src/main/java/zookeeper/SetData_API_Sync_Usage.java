package zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

/**
 * Created by lixianch on 2016/12/23.
 */
public class SetData_API_Sync_Usage implements Watcher {
    public static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    public static ZooKeeper zk = null;

    public static void main(String[] args) throws Exception{
        String path = "/zk-book";
        zk = new ZooKeeper("192.168.186.133,192.168.186.134,192.168.186.135:2181",5000,new SetData_API_Sync_Usage());
        connectedSemaphore.await();
        zk.create(path,"123".getBytes(),Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        zk.getData(path,true,null);
        Stat stat = zk.setData(path, "456".getBytes(), -1);
        System.out.println(stat.getCzxid()+","+stat.getMzxid()+","+stat.getVersion());
        Stat stat2 = zk.setData(path,"456".getBytes(),stat.getVersion());
        System.out.println(stat2.getCzxid()+","+stat2.getMzxid()+","+stat2.getVersion());
        try {
            zk.setData(path,"456".getBytes(),stat.getVersion());
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.sleep(Integer.MAX_VALUE);
    }
    @Override
    public void process(WatchedEvent watchedEvent) {
        if(KeeperState.SyncConnected == watchedEvent.getState()){
            connectedSemaphore.countDown();
        }
    }
}
