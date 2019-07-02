package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class ProducerTest {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.put("metadata.broker.list", "zookeeper2:9092");
        props.put("serializer.class", "kafka.serializer.StringEncoder");

        ProducerConfig producerConfig = new ProducerConfig(props);
        Producer<String, String> producer = new Producer<String, String>(producerConfig);

//         1개 보내기
        KeyedMessage<String, String> message = new KeyedMessage<String, String>("test", "Hello, World!");
        producer.send(message);
//         10개 한번에 보내기
//         List<KeyedMessage<String, String>> messages = new ArrayList<KeyedMessage<String, String>>();
//         for (int i = 0; i < 10; i++) {
//             messages.add(new KeyedMessage<String, String>("test", "Hello, World!"));
//         }


        producer.close();
    }
}