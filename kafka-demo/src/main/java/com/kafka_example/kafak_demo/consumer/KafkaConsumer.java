package com.kafka_example.kafak_demo.consumer;

import com.kafka_example.kafak_demo.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
public class KafkaConsumer {

//    @KafkaListener(topics = "first_topic", groupId = "myGroup")
    public void consumeMsg(String msg) {
        log.info(format("Consuming the message from first_topic:: %s", msg));

    }

    @KafkaListener(topics = "first_topic", groupId = "myGroup")
    public void consumeJsonMsg(Student student) {
        log.info(format("Consuming the message from first_topic:: %s", student.toString()));

    }
}
