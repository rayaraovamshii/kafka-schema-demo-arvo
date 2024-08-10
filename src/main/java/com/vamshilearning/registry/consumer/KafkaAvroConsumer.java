package com.vamshilearning.registry.consumer;

import com.vamshilearning.registry.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaAvroConsumer {

    @KafkaListener(topics ="${topic.name}")
    public void consume(ConsumerRecord<String, Employee> records) {

        String key = records.key();
        Employee employee = records.value();
        log.info("AVro Message for key : " + key + " and value : " + employee);
    }
}
