package zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooDefs.Ids;
import java.util.concurrent.CountDownLatch;

/**
 * Created by lixianch on 2016/12/23.
 */
public class Exist_API_Sync_Usage implements Watcher {
    public static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    public static ZooKeeper zk = null;

    public static void main(String[] args) throws Exception {
        String path = "/zk-book";
        zk = new ZooKeeper("192.168.186.133,192.168.186.134,192.168.186.135:2181",5000,new Exist_API_Sync_Usage());
        connectedSemaphore.await();
        zk.exists(path,true);
        zk.create(path,"".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.setData(path,"123".getBytes(),-1);
        zk.create(path+"/c1","456".getBytes(), Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL);
        zk.delete(path+"/c1",-1);
        zk.delete(path,-1);
        Thread.sleep(Integer.MAX_VALUE);
    }
    @Override
    public void process(WatchedEvent watchedEvent) {
        try {
            if(KeeperState.SyncConnected == watchedEvent.getState()){
                if(EventType.None == watchedEvent.getType() && watchedEvent.getPath() == null){
                    connectedSemaphore.countDown();
                }else if(EventType.NodeCreated == watchedEvent.getType()){
                    System.out.println("Node(" + watchedEvent.getPath() + ")Created");
                    zk.exists(watchedEvent.getPath(),true);
                }else if(EventType.NodeDeleted == watchedEvent.getType()){
                    System.out.println("Node(" + watchedEvent.getPath() + ")Deleted");
                    zk.exists(watchedEvent.getPath(),true);
                }else if(EventType.NodeDataChanged == watchedEvent.getType()){
                    System.out.println("Node(" + watchedEvent.getPath() + ")DataChanged");
                    zk.exists(watchedEvent.getPath(),true);
                }
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
