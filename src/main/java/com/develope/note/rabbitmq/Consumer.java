package com.develope.note.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues={"firstQueue"} , concurrency="4")
    public void receive1(String msg){
        System.out.println(msg);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues={"secondQueue"})
    public void receive2(String msg){
        System.out.println(msg + "<>receive2");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @RabbitListener(queues={"secondQueue"})
    public void receive22(String msg){
        System.out.println(msg + "<>receive22");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues={"secondQueue"})
    public void receive222(String msg){
        System.out.println(msg + "<>receive222");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues={"secondQueue"})
    public void receive2222(String msg){
        System.out.println(msg + "<>receive2222");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues={"thirdQueue"} , concurrency="4")
    public void receive3(String msg){
        System.out.println(msg);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
