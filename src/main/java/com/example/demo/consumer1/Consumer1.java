package com.example.demo.consumer1;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer1 {

    @JmsListener(destination = "${active.mq.queue.name}")
    public void consumerTest1(String message){
        System.out.println("============> Consumer 01: "+message);
    }
}
