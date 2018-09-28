package kafka;

/**
 * Created by lixianch on 2018/9/20.
 */
public class KafkaProperties {
    public static final String TOPIC = "topic_test";
    public static final String KAFKA_SERVER_URL = "192.168.186.133";
    public static final int KAFKA_SERVER_PORT = 9092;
    public static final int KAFKA_PRODUCER_BUFFER_SIZE = 64 * 1024;
    public static final int CONNECTION_TIMEOUT = 100000;

    private KafkaProperties(){}
}
