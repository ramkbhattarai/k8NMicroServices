package com.rkb.kafkaProducer.dto;

public class KafkaTopic {

    private String mainMessage;

    public String getMainMessage() {
        return mainMessage;
    }

    public void setMainMessage(String mainMessage) {
        this.mainMessage = mainMessage;
    }

    @Override
    public String toString() {
        return "KafkaTopic{" +
                "mainMessage='" + mainMessage + '\'' +
                '}';
    }
}
