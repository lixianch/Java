package zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by lixianch on 2016/12/23.
 */
public class ZooKeeper_GetChildren_API_ASync_Usage implements Watcher {
    public static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    public static ZooKeeper zk = null;

    public static void main(String[] args) throws Exception {
        String path = "/zk_book";
        zk = new ZooKeeper("192.168.186.133,192.168.186.134,192.168.186.135:2181",5000,new ZooKeeper_GetChildren_API_ASync_Usage());
        connectedSemaphore.await();
        zk.create(path,"".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.create(path+"/c1","".getBytes(), Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL);
        zk.getChildren(path,true,new IGetChildrenCallback(),null);
        zk.create(path+"/c2","".getBytes(), Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL);
        Thread.sleep(Integer.MAX_VALUE);
    }
    @Override
    public void process(WatchedEvent watchedEvent) {
        if(KeeperState.SyncConnected == watchedEvent.getState()){
            connectedSemaphore.countDown();
        }
    }
}

class IGetChildrenCallback implements AsyncCallback.Children2Callback{

    @Override
    public void processResult(int rc, String path, Object ctx, List<String> children, Stat stat) {
        System.out.println("Get Children znode result: [response code: " + rc + ", param path: " + path
                + ", ctx: " + ctx + ", children list: " + children + ", stat: " + stat);
    }
}
