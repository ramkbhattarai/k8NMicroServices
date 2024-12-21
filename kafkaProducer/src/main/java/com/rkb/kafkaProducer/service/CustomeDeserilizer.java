package com.rkb.kafkaProducer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rkb.kafkaProducer.dto.KafkaTopic;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class CustomeDeserilizer implements Serializer<KafkaTopic> {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }

    @Override
    public byte[] serialize(String s, KafkaTopic kafkaTopic) {
        try {
            if (kafkaTopic == null){
                System.out.println("Null received at serializing");
                return null;
            }
            System.out.println("Serializing...");
            return objectMapper.writeValueAsBytes(kafkaTopic);
        } catch (Exception e) {
            throw new SerializationException("Error when serializing kafkaTopic to byte[]");
        }
    }

    @Override
    public byte[] serialize(String topic, Headers headers, KafkaTopic data) {
        return Serializer.super.serialize(topic, headers, data);
    }

    @Override
    public void close() {
        Serializer.super.close();
    }
}
