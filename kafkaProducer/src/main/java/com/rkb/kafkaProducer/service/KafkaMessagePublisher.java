package com.rkb.kafkaProducer.service;

import com.rkb.kafkaProducer.dto.KafkaTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {
    Logger logger = LoggerFactory.getLogger(KafkaMessagePublisher.class);

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public String sendMessage(KafkaTopic kafkaTopic){
        CompletableFuture<SendResult<String, Object>> sentMessage = kafkaTemplate.send("rkb-topic", kafkaTopic);
        sentMessage.whenComplete((result, exception) -> {
            if(null != exception){
                throw new RuntimeException("exception is " + exception);
            }
        });
        logger.info("message sent {}",kafkaTopic);
        return kafkaTopic.toString();
    }
}
