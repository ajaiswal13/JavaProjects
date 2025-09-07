package com.enduser.enduserapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {

    @KafkaListener(topics="location-update-topic",groupId = "group-1")
    public void getLocation(String value){
         //Here value represents the data send by producer
        //We can do anything with this value i.e store in database
        System.out.println(value);
    }
}
