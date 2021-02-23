package com.example.demo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RestController
public class Producer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    @GetMapping("publish/{message}")
    public String publish(@PathVariable("message") String message){
        for(int i=0; i<10; i++){
            String str = "test"+String.valueOf(i);
            jmsTemplate.convertAndSend(queue, str);
        }
        jmsTemplate.convertAndSend(queue, message);
        return "Message is published";
    }
}
