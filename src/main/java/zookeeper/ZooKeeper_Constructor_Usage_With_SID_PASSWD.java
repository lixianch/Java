package zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by lixianch on 2016/12/22.
 */
public class ZooKeeper_Constructor_Usage_With_SID_PASSWD implements Watcher {
    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    public static void main(String[] args) {
        try {
            ZooKeeper zooKeeper = new ZooKeeper("192.168.186.133,192.168.186.134,192.168.186.135:2181",5000,new ZooKeeper_Constructor_Usage_With_SID_PASSWD());
            try {
                connectedSemaphore.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long sessionId = zooKeeper.getSessionId();
            byte[] pwd = zooKeeper.getSessionPasswd();
            zooKeeper = new ZooKeeper("192.168.186.133,192.168.186.134,192.168.186.135:2181",5000,new ZooKeeper_Constructor_Usage_With_SID_PASSWD(),1l,"test".getBytes());
            zooKeeper = new ZooKeeper("192.168.186.133,192.168.186.134,192.168.186.135:2181",5000,new ZooKeeper_Constructor_Usage_With_SID_PASSWD(),sessionId,pwd);
            try {
                Thread.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void process(WatchedEvent event) {
        System.out.println("Receive watched event：" + event);
        if(Event.KeeperState.SyncConnected == event.getState()){
            connectedSemaphore.countDown();
        }

    }
}
