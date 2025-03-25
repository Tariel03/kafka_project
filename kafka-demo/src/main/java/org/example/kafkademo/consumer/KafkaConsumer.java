package org.example.kafkademo.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.kafkademo.payload.Student;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

//    @KafkaListener(topics = "manga", groupId = "myGroup")
//    public void consumer(String message){
//        log.info("The following message is received: {}", message);
//    }

    @KafkaListener(topics = "students", groupId = "myGroup")
    public void consumer(Student message){
        log.info("The following message is received: {}", message);
    }
}
