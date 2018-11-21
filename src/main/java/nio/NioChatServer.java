package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by lixianch on 2018/1/17.
 */
public class NioChatServer {
    private Selector selector;
    public static void main(String[] args) throws IOException {
        NioChatServer nioChatServer = new NioChatServer();
        nioChatServer.initServer(8888);
        nioChatServer.listenSelector();
    }

    public void initServer(int port) throws IOException {
        //获取网络通道
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //设置非阻塞
        ssc.configureBlocking(false);
        //绑定端口
        ssc.socket().bind(new InetSocketAddress(port));
        //获取通道选择器
        selector = Selector.open();
        //绑定通道到选择器并注册监听连接事件
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务已经启动.....");
    }

    public void listenSelector() throws IOException {
        //轮训监听选择器
        while(true) {
            //最终会调用到操作系统中的多用复用选择器（本地方法）方法（如poll/epoll/select等）
            //等待客户连接
            this.selector.select();
            //迭代SelectionKey中的键值
            Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                //删除当前SelectionKey
                iterator.remove();
                //处理请求
                handle(key);


            }
        }
    }

    public void handle(SelectionKey key) throws IOException {
        if(key.isAcceptable()){//连接事件
            System.out.println("新客户端连接上了.....");
            ServerSocketChannel channel = (ServerSocketChannel) key.channel();
            SocketChannel sc = channel.accept();
            sc.configureBlocking(false);//设置成非阻塞
            sc.register(selector,SelectionKey.OP_READ);
        }else if(key.isReadable()){
            System.out.println("开始读取数据......");
            SocketChannel sc = (SocketChannel) key.channel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int count = sc.read(byteBuffer);
            if(count > -1){
                String info = new String(byteBuffer.array(),"UTF-8");
                System.out.println(Thread.currentThread().getName() + ",服务端读取数据==>" + info);
            }else {
                System.out.println("客户端关闭了......");
                key.cancel();
            }

        }
    }
}
