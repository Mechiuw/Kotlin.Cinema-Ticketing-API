package com.mcsoftware.ticketo.customer.controller

import com.mcsoftware.ticketo.customer.kafka.producer.KafkaProducer
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/messages")
class MessageController(
    private val producer : KafkaProducer
) {

    @PostMapping
    fun sendMessage(
        @RequestBody message:String
    ) : ResponseEntity<String>{
        producer.sendCustomerEvent(message);
        return ResponseEntity.ok("message successfully queued");
    }
}