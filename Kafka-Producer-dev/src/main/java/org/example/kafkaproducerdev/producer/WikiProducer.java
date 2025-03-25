package org.example.kafkaproducerdev.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class WikiProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    public void sendMessage(String message) {
        log.info("Sending message: {}", message);
        kafkaTemplate.send("wikimedia-stream", message);
    }

}
