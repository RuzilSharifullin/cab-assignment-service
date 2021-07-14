package com.drishticon.cabassignmentservice.service;

import com.drishticon.cabassignmentservice.domain.Cab;
import com.drishticon.cabassignmentservice.util.UuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CabLocationPublisher {

    @Autowired
    private final KafkaTemplate<String, Cab> kafkaTemplate;


    private String topic = "cab_location";

    public CabLocationPublisher(KafkaTemplate<String, Cab> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        kafkaTemplate.setDefaultTopic(topic);
    }

    @Async
    public void publish(Cab cab) {
        UUID uuid = UuidGenerator.generate();
        Message<Cab> message = MessageBuilder.withPayload(cab).setHeader("eventName", topic)
                .setHeader("eventID", "" + uuid)
                .build();
        kafkaTemplate.send(message);
    }
}
