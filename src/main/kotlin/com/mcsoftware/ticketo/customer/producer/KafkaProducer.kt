package com.mcsoftware.ticketo.customer.producer

import org.springframework.kafka.core.KafkaTemplate

class KafkaProducer(private val kafkaTemplate: KafkaTemplate<String,String>) {
    private val topic = "customer_topic"
    fun sendCustomerEvent(message : String){
        kafkaTemplate.send(topic,message);
    }
}