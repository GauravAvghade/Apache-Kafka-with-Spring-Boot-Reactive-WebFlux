package com.kafka_example.kafak_demo.rest;

import com.kafka_example.kafak_demo.payload.Student;
import com.kafka_example.kafak_demo.producer.KafkaJsonProducer;
import com.kafka_example.kafak_demo.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage(
            @RequestBody String message
    ) {
        System.out.println(message);
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message queued successfully");
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(
            @RequestBody Student message
    ) {
        System.out.println(message);
        kafkaJsonProducer.sendMessage(message);
        return ResponseEntity.ok("Message queued successfully as JSON");
    }
}
