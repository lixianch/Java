package kafka.producer;

import kafka.KafkaProperties;
import org.apache.kafka.clients.Metadata;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * Created by lixianch on 2018/9/19.
 */
public class Producer extends Thread {
    private final KafkaProducer<Integer, String> producer;
    private final String topic;
    private final Boolean isAsync;

    public Producer(String topic, Boolean isAsync) {
        Properties prop = new Properties();
        prop.put("bootstrap.servers", KafkaProperties.KAFKA_SERVER_URL + ":" + KafkaProperties.KAFKA_SERVER_PORT);
        prop.put("client.id", "DemoProducer");
        prop.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
        prop.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<Integer, String>(prop);
        this.topic = topic;
        this.isAsync = isAsync;
    }

    @Override
    public void run() {
        int messageNo = 1;
        while (true){
            String messageStr = "Message_" + messageNo;
            long startTime = System.currentTimeMillis();
            if(isAsync){
                producer.send(new ProducerRecord<>(topic,messageNo,messageStr),new DemoCallBack(startTime,messageNo,messageStr));
            }else {
                try {
                    producer.send(new ProducerRecord<>(topic, messageNo, messageStr)).get();
                    String log = String.format("Sent message: (%d, %s)", messageNo, messageStr);
                    System.out.println(log);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            ++messageNo;
        }
    }
}

class DemoCallBack implements Callback {
    private final Long startTime;
    private final int key;
    private final String message;
    public DemoCallBack(Long startTime,int key,String message){
        this.startTime = startTime;
        this.key = key;
        this.message = message;
    }
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        long elapseTime = System.currentTimeMillis() - startTime;
        if(recordMetadata != null){
            String log = String.format("message(%d, %s) sent to partition(%d), " + "offset(%d) in %d ms", key, message, recordMetadata.partition(), recordMetadata.offset(),elapseTime);
            System.out.println(log);
        }else {
            e.printStackTrace();
        }
    }
}
