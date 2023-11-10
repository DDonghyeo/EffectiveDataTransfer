package com.example.EffectiveDataTransfer.Kafka.component;

import com.example.EffectiveDataTransfer.RDB.dto.CreateTaskEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
@RequiredArgsConstructor
public class Producer {

    private final KafkaTemplate kafkaTemplate;

    private final String TOPIC_TASK = "TOPIC1";

    //Spring Boot 2
    /*
    public void sendEvent2(CreateTaskEvent event) {
        ListenableFuture<SendResult<String, CreateTaskEvent>> future = kafkaTemplate.send(TOPIC_TASK, event);
        future.addCallback(
                result -> log.info("offset : {}" , result.getRecordMetadata().offset()),
                throwable -> log.error("fail to publish", throwable)

        );
    }

     **/

    //Spring Boot 3
    public void sendEvent3(CreateTaskEvent event) {
        CompletableFuture<SendResult<String, CreateTaskEvent>> future = kafkaTemplate.send(TOPIC_TASK, event);
        future.whenComplete(((result, throwable) -> {
            if (throwable == null) {
                log.info("offset : {}", result.getRecordMetadata().offset());
            } else {
                log.error("fail to publish", throwable);
            }
        }
        ));
    }
}
