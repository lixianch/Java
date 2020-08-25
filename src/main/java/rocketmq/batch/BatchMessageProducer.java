package rocketmq.batch;

import com.google.common.collect.Lists;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import java.util.List;

/**
 * Created by lixianch on 2020/8/4
 */
public class BatchMessageProducer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer("batchMessageProducer");
        producer.setNamesrvAddr("192.168.186.133:9876");
        producer.start();
        int totalMsgCount = 1000;
        List<Message> msgs = Lists.newArrayList();
        for (int i = 0; i < totalMsgCount; i++) {
            Message msg = new Message("batchTopicTest", ("batch message " + i).getBytes());
            msgs.add(msg);
        }
        //把大的消息分裂成若干个小的消息
        ListSplitter splitter = new ListSplitter(msgs);
        while (splitter.hasNext()) {
            try {
                List<Message>  listItem = splitter.next();
                producer.send(listItem);
            } catch (Exception e) {
                e.printStackTrace();
                //处理error
            }
        }
        producer.shutdown();
    }
}
