package com.example.EffectiveDataTransfer.RDB.Repository;

import com.example.EffectiveDataTransfer.RDB.Entity.Event;
import com.example.EffectiveDataTransfer.RDB.Enum.EventStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {

    public List<Event> findByCreatedAtBefore(LocalDateTime localDateTime, EventStatus eventStatus);
}
