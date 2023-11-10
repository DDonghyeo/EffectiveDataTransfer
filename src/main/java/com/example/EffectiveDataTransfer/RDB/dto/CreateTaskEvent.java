package com.example.EffectiveDataTransfer.RDB.dto;

import com.example.EffectiveDataTransfer.RDB.Entity.Event;
import com.example.EffectiveDataTransfer.RDB.Entity.Task;
import com.example.EffectiveDataTransfer.RDB.Enum.EventStatus;

public class CreateTaskEvent {

    public static Event of(Task task) {
        return Event.builder()
                .status(EventStatus.READY)
                .payload(task.getTask_content())
                .build();
    }
}
