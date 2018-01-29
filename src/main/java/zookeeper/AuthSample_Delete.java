package zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;
/**
 * Created by lixianch on 2016/12/23.
 */
public class AuthSample_Delete {
    final static String PATH  = "/zk-book-auth_test";
    final static String PATH2 = "/zk-book-auth_test/child";

    public static void main(String[] args) throws Exception{
        ZooKeeper zk = new ZooKeeper("192.168.186.133,192.168.186.134,192.168.186.135:2181",5000,null);
        zk.addAuthInfo("digest","foo:true".getBytes());
        zk.create(PATH,"init".getBytes(), Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
        zk.create(PATH2,"init".getBytes(), Ids.CREATOR_ALL_ACL,CreateMode.EPHEMERAL);
        ZooKeeper zk1 = new ZooKeeper("192.168.186.133,192.168.186.134,192.168.186.135:2181",5000,null);
        try {
            zk1.delete(PATH,-1);
        } catch (Exception e) {
            System.out.println("删除节点失败: " + e.getMessage());
        }
        ZooKeeper zk2 = new ZooKeeper("192.168.186.133,192.168.186.134,192.168.186.135:2181",5000,null);
        zk2.addAuthInfo("digest","foo:true".getBytes());
        zk2.delete(PATH2,-1);
        System.out.println("成功删除节点：" + PATH2 );
        ZooKeeper zk4 = new ZooKeeper("192.168.186.133,192.168.186.134,192.168.186.135:2181",5000,null);
        zk4.addAuthInfo("digest","foo:true".getBytes());
        zk4.delete(PATH,-1);
        System.out.println("成功删除节点：" + PATH );
    }
}
