package com.develope.note.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig {

    @Bean(name = "DIRECT_EXCHANGE")
    public DirectExchange getDirectExchange(){
        return new DirectExchange("directExchange");
    }

    @Bean(name = "TOPIC_EXCHANGE")
    public TopicExchange getTopicExchange(){
        return new TopicExchange("topicExchange");
    }

    @Bean(name = "FANOUT_EXCHANGE")
    public FanoutExchange getFanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    @Bean(name = "firstQueue")
    public Queue getFirstQueue(){
        return new Queue("firstQueue");
    }

    @Bean(name = "secondQueue")
    public Queue getSecondQueue(){
        return new Queue("secondQueue", true);
    }

    @Bean(name = "thirdQueue")
    public Queue getThirdQueue(){
        return new Queue("thirdQueue");
    }

    @Bean
    public Binding bindingDirect(@Qualifier("DIRECT_EXCHANGE") DirectExchange directExchange, @Qualifier("firstQueue") Queue queue){
        return BindingBuilder.bind(queue).to(directExchange).with("com.liujin");
    }

    @Bean
    public Binding bindingTopic(@Qualifier("TOPIC_EXCHANGE") TopicExchange topicExchange, @Qualifier("secondQueue") Queue queue){
        return BindingBuilder.bind(queue).to(topicExchange).with("*.liujin.*");
    }

    @Bean
    public Binding bindingFanout(@Qualifier("FANOUT_EXCHANGE") FanoutExchange fanoutExchange, @Qualifier("thirdQueue") Queue queue){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

}
