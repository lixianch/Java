package zookeeper;

import org.I0Itec.zkclient.ZkClient;

/**
 * Created by lixianch on 2016/12/23.
 */
public class Set_Data_Sample {
    public static void main(String[] args) {
        String path = "/zk-book";
        ZkClient zk = new ZkClient("192.168.186.133,192.168.186.134,192.168.186.135:2181",5000);
        zk.createEphemeral(path,new Integer(1));
        zk.writeData(path,new Integer(1));
    }
}
