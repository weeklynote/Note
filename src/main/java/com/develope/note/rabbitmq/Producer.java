package com.develope.note.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send(){
        rabbitTemplate.convertAndSend("directExchange", "com.liujin", "this a directExchange msg1!");
        rabbitTemplate.convertAndSend("directExchange", "com.liujin", "this a directExchange msg2!");
        rabbitTemplate.convertAndSend("directExchange", "com.liujin", "this a directExchange msg3!");
        rabbitTemplate.convertAndSend("directExchange", "com.liujin", "this a directExchange msg4!");
        rabbitTemplate.convertAndSend("topicExchange", "com.liujin.cn", "this a topicExchange msg1!");
        rabbitTemplate.convertAndSend("topicExchange", "com.liujin.com", "this a topicExchange msg2!");
        rabbitTemplate.convertAndSend("topicExchange", "com.liujin.com", "this a topicExchange msg3!");
        rabbitTemplate.convertAndSend("topicExchange", "com.liujin.com", "this a topicExchange msg4!");
        rabbitTemplate.convertAndSend("topicExchange", "com.liujin.com", "this a topicExchange msg5!");
        rabbitTemplate.convertAndSend("topicExchange", "com.liujin.com", "this a topicExchange msg6!");
        rabbitTemplate.convertAndSend("topicExchange", "com.liujin.com", "this a topicExchange msg7!");
        rabbitTemplate.convertAndSend("topicExchange", "com.liujin.com", "this a topicExchange msg8!");
        rabbitTemplate.convertAndSend("topicExchange", "com.liujin.com", "this a topicExchange msg9!");
        rabbitTemplate.convertAndSend("topicExchange", "com.liujin.com", "this a topicExchange msg10!");
        rabbitTemplate.convertAndSend("fanoutExchange", "", "this a fanoutExchange msg1!");
        rabbitTemplate.convertAndSend("fanoutExchange", "", "this a fanoutExchange msg2!");
        rabbitTemplate.convertAndSend("fanoutExchange", "", "this a fanoutExchange msg3!");
        rabbitTemplate.convertAndSend("fanoutExchange", "", "this a fanoutExchange msg4!");
    }
}
