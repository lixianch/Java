package zookeeper;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;

/**
 * Created by lixianch on 2016/12/23.
 */
public class Get_Children_Sample {
    public static void main(String[] args) throws Exception{
        String path = "/zk-book";
        ZkClient zk = new ZkClient("192.168.186.133,192.168.186.134,192.168.186.135:2181",5000);
        zk.subscribeChildChanges(path, new IZkChildListener() {
            @Override
            public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
                System.out.println(parentPath + " 's child changed, currentChilds:" + currentChilds);
            }
        });
        zk.createPersistent(path);
        Thread.sleep(1000);
        System.out.println(zk.getChildren(path));
        Thread.sleep(1000);
        zk.createPersistent(path +"/c1");
        Thread.sleep(1000);
        System.out.println(zk.getChildren(path));
        Thread.sleep(1000);
        zk.delete(path + "/c1");
        Thread.sleep(1000);
        zk.delete(path);
        Thread.sleep(Integer.MAX_VALUE);
    }
}
