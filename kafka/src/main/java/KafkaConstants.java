package com.pratik.kafka;

public enum KafkaConstants {


    BROKER_URL("localhost:9092"),
    CLIENT_ID ("CLIENT_ID1"),
    TOPIC_NAME("TOPIC1"),
    MAX_POLL_RECORDS("10"),
    OFFSET_RESET_EARLIER("earliest"),
    GROUP_ID_CONFIG("consumerGroup1");


    private String value;

    KafkaConstants(final String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
