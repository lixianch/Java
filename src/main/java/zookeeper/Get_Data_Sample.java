package zookeeper;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

/**
 * Created by lixianch on 2016/12/23.
 */
public class Get_Data_Sample {
    public static void main(String[] args) throws Exception{
        String path = "/zk-book";
        ZkClient zk = new ZkClient("192.168.186.133,192.168.186.134,192.168.186.135:2181",5000);
        zk.createEphemeral(path,"123");
        zk.subscribeDataChanges(path,new IZkDataListener(){
            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                System.out.println("Node " + dataPath + " changed, new data: " + data);
            }

            @Override
            public void handleDataDeleted(String dataPath) throws Exception {
                System.out.println("Node " + dataPath + " deleted.");
            }
        });
//        System.out.println(zk.readData(path));
        zk.writeData(path,"456");
        Thread.sleep(1000);
        zk.delete(path);
        Thread.sleep(Integer.MAX_VALUE);
    }
}
