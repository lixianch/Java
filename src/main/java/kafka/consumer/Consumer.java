package kafka.consumer;

import kafka.utils.ShutdownableThread;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.consumer.ConsumerConfig;

import java.util.Collections;
import java.util.Properties;

/**
 * Created by lixianch on 2018/9/20.
 */
public class Consumer extends ShutdownableThread {
    private final KafkaConsumer<Integer,String> consumer;
    private final String topic;
    public Consumer(String topic){
        super("KafkaConsumerExample", false);
        Properties prop = new Properties();
        prop.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.186.133:9092");
        prop.put(ConsumerConfig.GROUP_ID_CONFIG, "DemoConsumer");
        prop.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        prop.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 1000);
        prop.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 6000);
        prop.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, 1000);
        prop.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.IntegerDeserializer");
        prop.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");

        consumer = new KafkaConsumer<Integer, String>(prop);
        this.topic = topic;
    }
    @Override
    public void doWork() {
        consumer.subscribe(Collections.singletonList(this.topic));
        ConsumerRecords<Integer, String> records = consumer.poll(1000);
        for (ConsumerRecord<Integer, String> record : records) {
            String log = String.format("Received message: (%d , %s) at offset %d", record.key(), record.value(), record.offset());
            System.out.println(log);
        }
    }
}
