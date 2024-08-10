package com.vamshilearning.registry.controller;

import com.vamshilearning.registry.dto.Employee;
import com.vamshilearning.registry.producer.KafkaAvroProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @Autowired
    private KafkaAvroProducer kafkaAvroProducer;

    @PostMapping("/events")
    public String sendEvent(Employee event) {

        kafkaAvroProducer.send(event);

        return "Event sent successfully";
    }
}
