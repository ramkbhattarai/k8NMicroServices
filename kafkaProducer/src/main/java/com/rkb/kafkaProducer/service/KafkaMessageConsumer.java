package com.rkb.kafkaProducer.service;

import com.rkb.kafkaProducer.dto.KafkaTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageConsumer {
    Logger logger = LoggerFactory.getLogger(KafkaMessageConsumer.class);

    @KafkaListener(groupId = "ramkb-1", topics = "rkb-topic", containerFactory = "userKafkaListenerContainerFactory")
    public KafkaTopic getJsonMsgFromTopic(KafkaTopic user) {
        logger.info("Message consumed: {}", user);
        return user;
    }
}
