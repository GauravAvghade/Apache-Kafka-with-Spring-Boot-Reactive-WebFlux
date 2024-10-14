package com.kafka_example.kafak_demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic firstTopic() {
        return TopicBuilder
                .name("first_topic")
                .build();
    }
}
