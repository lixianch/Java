package zookeeper;

import org.I0Itec.zkclient.ZkClient;

/**
 * Created by lixianch on 2016/12/23.
 */
public class Create_Node_Sample {
    public static void main(String[] args) throws Exception{
        ZkClient zk = new ZkClient("192.168.186.133,192.168.186.134,192.168.186.135:2181",5000);
        String path = "/zk-book/c1";
        zk.createPersistent(path,true);
    }
}
