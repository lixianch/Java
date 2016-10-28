package zookeeper;

import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by lixianch on 2016/10/24.
 */
public class Executor {
    private ZooKeeper zk;
    private String znode;
    private String filename;
    private String[] exec;
    public static void main(String[] args){
        if(args.length < 4){
            System.err.println("USAGE: Executor hostPort znode filename program [args ...]");
            System.exit(2);
        }

        String hostPort = args[0];
        String znode = args[1];
        String filename = args[2];
        String[] exec = new String[args.length - 3];
        System.arraycopy(args,3,exec,0,exec.length);

    }

    public Executor(String hostPort,String znode,String filename,String[] exec){
        this.filename = filename;
        this.exec = exec;
//        try {
//            zk = new ZooKeeper(hostPort, 3000, this);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //dm = new DataMonitor(zk, znode, null, this);
    }

    public void run(){
        synchronized (this){

        }
    }
}
