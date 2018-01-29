package zookeeper;

import org.I0Itec.zkclient.ZkClient;

/**
 * Created by lixianch on 2016/12/23.
 */
public class Exist_Node_Sample {
    public static void main(String[] args) throws Exception{
        String path = "/zk-book";
        ZkClient zk = new ZkClient("192.168.186.133,192.168.186.134,192.168.186.135:2181",5000);
        System.out.println("Node " + path + " exists " + zk.exists(path));
    }
}
