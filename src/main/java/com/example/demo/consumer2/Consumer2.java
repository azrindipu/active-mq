package com.example.demo.consumer2;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer2 {

    @JmsListener(destination = "${active.mq.queue.name}")
    public void consumerTest2(String message){
        System.out.println("============> Consumer 02: "+message);
    }
}
