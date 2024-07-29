package com.mcsoftware.ticketo.kafka.controller

import com.mcsoftware.ticketo.json.AppEndpoint
import com.mcsoftware.ticketo.kafka.producer.KafkaProducer
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(AppEndpoint.MESSAGE)
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