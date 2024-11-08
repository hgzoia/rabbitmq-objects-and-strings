package br.com.hugo.producer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static constants.RabbitMqConstants.EXG_NAME;
import static constants.RabbitMqConstants.ROUTING_KEY_NAME;


@Log4j2
@Service
@RequiredArgsConstructor
public class StringService {

    private final RabbitTemplate rabbitTemplate;

    public void createMessage(String message){
        log.info("Received message: {}", message);
        rabbitTemplate.convertAndSend(EXG_NAME, ROUTING_KEY_NAME, message);
    }

}
