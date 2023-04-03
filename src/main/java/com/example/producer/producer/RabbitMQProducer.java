package com.example.producer.producer;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@EnableAutoConfiguration
public class RabbitMQProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;



   /* @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }*/
   //ConnectionFactory
  //ConnectionFactory  connectionFactory = new CachingConnectionFactory("20.160.215.39", 5672);


  //  RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

    /**
     *
     */
   @Autowired
    private RabbitTemplate rabbitTemplate;



    public void sendMessage(String message){

        rabbitTemplate.convertAndSend(
                exchange, routingKey, message);
    }
}
