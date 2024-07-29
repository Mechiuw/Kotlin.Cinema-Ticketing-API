package com.mcsoftware.ticketo.kafka.producer

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service


@Service
class KafkaProducer(private val kafkaTemplate: KafkaTemplate<String,String>) {
    fun sendCustomerEvent(message : String){
        println("sending messages to topic => [ $message ]")
        kafkaTemplate.send("[TOPIC] : ",message);
    }
}