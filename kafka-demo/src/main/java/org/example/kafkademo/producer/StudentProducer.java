package org.example.kafkademo.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.kafkademo.payload.Student;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentProducer {
    private final KafkaTemplate<String, Student> kafkaTemplate;
    public void sendMessage(Student student) {
        Message<Student> message  = MessageBuilder
                .withPayload(student)
                .setHeader(KafkaHeaders.TOPIC, "students")
                .build();
        kafkaTemplate.send("students", student);
    }

}
