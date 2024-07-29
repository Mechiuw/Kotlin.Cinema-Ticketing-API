package com.mcsoftware.ticketo.customer.kafka.topic

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaTopicConfig {

    @Bean
    fun testTopic() :NewTopic {
        return TopicBuilder
            .name("kafka topics")
            .build()
    }
}