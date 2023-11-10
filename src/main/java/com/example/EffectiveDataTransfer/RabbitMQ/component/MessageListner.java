package com.example.EffectiveDataTransfer.RabbitMQ.component;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;


@Component
@Slf4j
public class MessageListner {

    @RabbitListener(queues = "test.task")
    public void receiveMessage(Message message, Channel channel) throws IOException {

        //수동 ACK 전송
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

        //수동 NACK 전송
        channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
    }

    @RabbitListener(
            queues = "test.deadletter",
            containerFactory = "deadLetterContainerFactory"
    )
    public void onDeadLetterMessage(Map<String, Object> rawEvent) {
        log.info("Dead Letter Message");
        // Alert failure or fallback
    }
}
