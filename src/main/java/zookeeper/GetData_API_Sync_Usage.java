package zookeeper;

import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.data.Stat;

/**
 * Created by lixianch on 2016/12/23.
 */
public class GetData_API_Sync_Usage implements Watcher {
    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    private static Stat stat = new Stat();
    public static void main(String[] args) throws Exception{
        String path = "/zk-book";
        ZooKeeper zookeeper = new ZooKeeper("192.168.186.133,192.168.186.134,192.168.186.135:2181",5000,new GetData_API_Sync_Usage());
        connectedSemaphore.await();
        zookeeper.create(path,"123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println(new String(zookeeper.getData(path,true,stat)));
        System.out.println(stat.getCzxid()+","+stat.getMzxid()+","+stat.getVersion());
        zookeeper.setData(path,"123".getBytes(),-1);
        Thread.sleep(Integer.MAX_VALUE);
    }
    @Override
    public void process(WatchedEvent watchedEvent) {
        if(KeeperState.SyncConnected == watchedEvent.getState()){
            connectedSemaphore.countDown();
        }
    }
}
