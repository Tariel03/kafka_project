package org.example.kafkaproducerdev.wiki;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.kafkaproducerdev.producer.WikiProducer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class WikiMediaStreamConsumer {
    private final WebClient webClientBuilder;
    private final WikiProducer wikiProducer;

    public WikiMediaStreamConsumer(WebClient.Builder webClientBuilder, WikiProducer wikiProducer) {
        this.webClientBuilder = webClientBuilder
                .baseUrl("https://stream.wikimedia.org/v2")
                .build();
        this.wikiProducer = wikiProducer;
    }
    public void consumeSteamAndPublish() {
        webClientBuilder.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(wikiProducer::sendMessage);
    }
}
