package zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * Created by lixianch on 2017/1/5.
 */
public class PathChildrenCache_Sample_NoCacheData {
    static String path = "/zk-book";
    static CuratorFramework client = CuratorFrameworkFactory.builder().connectString("192.168.186.133,192.168.186.134,192.168.186.135:2181")
            .connectionTimeoutMs(5000).retryPolicy(new ExponentialBackoffRetry(1000,3)).build();

    public static void main(String[] args) throws Exception{
        client.start();
        final PathChildrenCache cache = new PathChildrenCache(client,path,true);//new PathChildrenCache(client,path,false);
        cache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
        cache.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent event) throws Exception {
                switch (event.getType()){
                    case CHILD_ADDED:
                        try {
                            System.out.println("CHILD_ADDED," + new String(event.getData().getData()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case CHILD_UPDATED:
                        System.out.println("CHILD_UPDATED," + new String(event.getData().getData()));
                        break;
                    case CHILD_REMOVED:
                        System.out.println("CHILD_REMOVED," + event.getData().getPath());
                        break;
                    default:
                        break;
                }
            }
        });
        client.create().withMode(CreateMode.PERSISTENT).forPath(path,"init".getBytes());
        Thread.sleep(1000);
        client.create().withMode(CreateMode.PERSISTENT).forPath(path +"/c1","init".getBytes());
        Thread.sleep(1000);
        client.delete().forPath(path + "/c1");
        Thread.sleep(1000);
        client.delete().forPath(path);
        Thread.sleep(10000);
        client.close();
    }
}
