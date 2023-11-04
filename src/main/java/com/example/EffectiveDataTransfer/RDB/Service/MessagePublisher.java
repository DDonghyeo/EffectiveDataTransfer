package com.example.EffectiveDataTransfer.RDB.Service;

import com.example.EffectiveDataTransfer.RDB.Enum.EventStatus;
import com.example.EffectiveDataTransfer.RDB.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;

@Service
public class MessagePublisher {

    @Autowired
    private EventRepository eventRepository;



    @Scheduled(cron = "0/5 * * * * *")
    @Transactional
    public void publish() {
        System.out.println("Publishing ------------> {}");
        LocalDateTime now = LocalDateTime.now();
        eventRepository.findByCreatedAtBefore(now, EventStatus.READY)
                .stream()
                .map(event -> restTemplate.execute(event))
                .map(event -> event.done())
                .forEach(eventRepository::save);

    }
}
