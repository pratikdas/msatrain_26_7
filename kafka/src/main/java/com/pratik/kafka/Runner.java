package com.pratik.kafka;

import com.pratik.kafka.consumers.ConsumerCreator;
import com.pratik.kafka.producers.ProducerCreator;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import com.pratik.kafka.KafkaConstants;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

public class Runner {
    private final Logger log = LoggerFactory.getLogger(getClass());


    public static void main(String[] args){
        ProducerCreator producerCreator = new ProducerCreator();
        
        producerCreator.sendMessage();

        ConsumerCreator consumerCreator = new ConsumerCreator();

        consumerCreator.readMessage();

    }
}
