package com.rkb.kafkaProducer.controller;

import com.rkb.kafkaProducer.dto.KafkaTopic;
import com.rkb.kafkaProducer.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaMessagePublisher kafkaMessagePublisher;

    @PostMapping("/sendTopic")
    public String sendTopic(@RequestBody KafkaTopic kafkaTopic){
        try{
           return kafkaMessagePublisher.sendMessage(kafkaTopic);
        }catch (Exception e){
            throw e;
        }

    }
}
