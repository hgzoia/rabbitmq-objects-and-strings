package br.com.hugo.producer.service;

import dtos.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static constants.RabbitMqConstants.EXG_NAME;
import static constants.RabbitMqConstants.ROUTING_KEY_NAME;

@Log4j2
@Service
@RequiredArgsConstructor
public class ProductService {

    private final RabbitTemplate template;

    public void createProduct(ProductDTO product){
        log.info("Sending message to exchange: {}", product.toString());
        template.convertAndSend(EXG_NAME, ROUTING_KEY_NAME, product);
    }

}
