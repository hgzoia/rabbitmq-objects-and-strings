package br.com.hugo.producer.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static constants.RabbitMqConstants.*;

@Configuration
@RequiredArgsConstructor
public class RabbitMqConfig {

    @Bean
    public Queue queue(){
        return new Queue(QUEUE_NAME, false, false, false);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(EXG_NAME, false, false);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(directExchange())
                .with(ROUTING_KEY_NAME);
    }

}
