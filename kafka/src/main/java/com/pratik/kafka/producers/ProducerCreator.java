package com.pratik.kafka.producers;

import com.pratik.kafka.KafkaConstants;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerCreator {

    public static Producer<Long, String> createProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.BROKER_URL.getValue());
        props.put(ProducerConfig.CLIENT_ID_CONFIG, KafkaConstants.CLIENT_ID.getValue());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return new KafkaProducer<>(props);
    }

    public void sendMessage(){
        Producer<Long, String> producer = ProducerCreator.createProducer();
        for(int i=0; i < 10; ++i){
            final ProducerRecord<Long, String> record = new ProducerRecord<Long, String>(KafkaConstants.TOPIC_NAME.getValue(),
                    "This is record " + i);

            try {
                RecordMetadata metadata = producer.send(record).get();
                System.out.println("Record sent with key " + i + " to partition " + metadata.partition()
                        + " with offset " + metadata.offset());
            }catch (Exception ex){
                ex.printStackTrace(System.out);
            }
        }
    }
}
