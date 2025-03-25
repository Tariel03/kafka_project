package org.example.kafkaconsumerdev.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class WikiConsumer {
    @KafkaListener(topics = "wikimedia-stream", groupId = "myGroup")
    public void consumer(String message){
        log.info("The following message is received: {}", message);
    }
}
