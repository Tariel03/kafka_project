package org.example.kafkademo.controller;

import lombok.RequiredArgsConstructor;
import org.example.kafkademo.payload.Student;
import org.example.kafkademo.producer.KafkaProducer;
import org.example.kafkademo.producer.StudentProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/message")
public class MessageController {
    private final KafkaProducer kafkaProducer;
    private final StudentProducer studentProducer;
    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("The following message has been sent: " + message);
    }

    @PostMapping("/send/student")
    public ResponseEntity<String> sendStudent(@RequestBody Student student) {
        studentProducer.sendMessage(student);
        return ResponseEntity.ok("The following message has been sent: " + student);
    }
}
