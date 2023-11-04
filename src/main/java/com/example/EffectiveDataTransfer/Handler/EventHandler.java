package com.example.EffectiveDataTransfer.Handler;

import com.example.EffectiveDataTransfer.dto.CreateTaskEvent;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.web.client.RestTemplate;

@Service
public class EventHandler {

    @Retryable(maxAttempts = 3, backoff = @Backoff(delay = 100L))
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void propagate(CreateTaskEvent event) {
        //이벤트 발생 로직
        System.out.println("이벤트 발생");
        // restTemplate.execute(...);
        // rabbitTemplate.send(...);
    }
}
