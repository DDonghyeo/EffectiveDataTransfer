package com.example.EffectiveDataTransfer.RabbitMQ.service;

import com.example.EffectiveDataTransfer.RDB.dto.CreateTaskEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

@AllArgsConstructor
@Service
public class MessagePublisher {

    private final ObjectMapper objectMapper;

    private final RabbitTemplate rabbitTemplate;

    private final String EXCHANGE_NAME = "EXCHANGE_NAME";
    private final String ROUTING_KEY = "ROUTING_KEY";

    public void sendMessage(CreateTaskEvent createTaskEvent) throws JsonProcessingException{
        String json = objectMapper.writeValueAsString(createTaskEvent);
        rabbitTemplate.send(EXCHANGE_NAME,
                ROUTING_KEY,
                new Message(json.getBytes(StandardCharsets.UTF_8)),
                new CorrelationData(UUID.randomUUID().toString()));
    }
}

