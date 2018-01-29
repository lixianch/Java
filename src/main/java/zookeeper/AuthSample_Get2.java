package zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;
/**
 * Created by lixianch on 2016/12/23.
 */
public class AuthSample_Get2 {
    final static String PATH = "/zk-book-auth_test";

    public static void main(String[] args) throws Exception{
        ZooKeeper zk = new ZooKeeper("192.168.186.133,192.168.186.134,192.168.186.135:2181",5000,null);
        zk.addAuthInfo("digest","foo:true".getBytes());
        zk.create(PATH,"init".getBytes(), Ids.CREATOR_ALL_ACL, CreateMode.EPHEMERAL);
        ZooKeeper zk1 = new ZooKeeper("192.168.186.133,192.168.186.134,192.168.186.135:2181",5000,null);
        zk1.addAuthInfo("digest","foo:true".getBytes());
        System.out.println(new String(zk1.getData(PATH, false, null)));
        ZooKeeper zk2 = new ZooKeeper("192.168.186.133,192.168.186.134,192.168.186.135:2181",5000,null);
        zk2.addAuthInfo("digest","foo:false".getBytes());
        zk2.getData(PATH,false,null);
    }
}
