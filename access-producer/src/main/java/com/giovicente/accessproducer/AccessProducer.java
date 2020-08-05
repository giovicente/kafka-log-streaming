package com.giovicente.accessproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class AccessProducer {

    @Autowired
    private KafkaTemplate<String, Access> producer;

    public void sendToKafka(Access access) {
        Random randomAccess = new Random();
        access.setAccessAllowed(randomAccess.nextBoolean());

        access.setAccessDate(LocalDateTime.now());

        producer.send("spec3-giovanni-vicente-1", access);
    }

}
