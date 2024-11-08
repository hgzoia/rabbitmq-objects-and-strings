package br.com.hugo.consumer.rabbitmq.consumer;

import dtos.ProductDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static constants.RabbitMqConstants.ROUTING_KEY_NAME;

@Log4j2
@Component
public class ProductConsumer {

    @RabbitListener(queues = {ROUTING_KEY_NAME})
    public void consumer(ProductDTO product){
        log.info("Message received: {}", product.toString());
    }

}
