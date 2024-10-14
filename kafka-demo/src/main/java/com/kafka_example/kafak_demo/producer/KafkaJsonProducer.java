package com.kafka_example.kafak_demo.producer;

import com.kafka_example.kafak_demo.payload.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaJsonProducer {

    private final KafkaTemplate<String, Student> kafkaTemplate;

    public void sendMessage(Student student) {
        // build the message
        Message<Student> message = MessageBuilder
                .withPayload(student)
                .setHeader(KafkaHeaders.TOPIC, "first_topic")
                .build();

        //send the message
        kafkaTemplate.send(message);

    }
}
