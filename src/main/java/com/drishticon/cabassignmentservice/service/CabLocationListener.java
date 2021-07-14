package com.drishticon.cabassignmentservice.service;

import com.drishticon.cabassignmentservice.domain.Cab;
import com.drishticon.cabassignmentservice.repository.CabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class CabLocationListener {

    @Autowired
    CabRepository repository;

    @KafkaListener(topics = "cab_location", groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
    public void consume(Message<Cab> message) {
        Cab cab = message.getPayload();
        cab.setAssigned(false);
        repository.save(cab);
    }
}
