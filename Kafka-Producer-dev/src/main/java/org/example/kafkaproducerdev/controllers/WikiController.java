package org.example.kafkaproducerdev.controllers;

import lombok.RequiredArgsConstructor;
import org.example.kafkaproducerdev.producer.WikiProducer;
import org.example.kafkaproducerdev.wiki.WikiMediaStreamConsumer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wiki")
@RequiredArgsConstructor
public class WikiController {
    private final WikiMediaStreamConsumer consumer;
    @GetMapping
    public void startPublishing(){
        consumer.consumeSteamAndPublish();
    }
}
