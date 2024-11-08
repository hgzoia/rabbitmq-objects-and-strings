package br.com.hugo.producer.controller;

import br.com.hugo.producer.service.StringService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/producer")
@RequiredArgsConstructor
public class StringController {

    private final StringService service;

    @PostMapping
    public ResponseEntity<String> messageProducer(@RequestBody String message){
        service.createMessage(message);
        return ResponseEntity.ok().build();
    }
}
