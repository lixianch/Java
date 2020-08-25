package rocketmq.delay;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * Created by lixianch on 2020/8/4
 */
public class ScheduledMessageProducer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("ExampleProducerGroup");
        producer.setNamesrvAddr("192.168.186.133:9876");
        producer.start();
        int totalMessagesToSend = 100;
        for (int i = 0; i < totalMessagesToSend; i++) {
            Message msg = new Message("TestTopic", ("Hello scheduled message " + i).getBytes());
            msg.setDelayTimeLevel(2);
            producer.send(msg);
        }
        producer.shutdown();
    }
}
