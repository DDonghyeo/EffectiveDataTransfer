package com.example.EffectiveDataTransfer.RDB.dto;

import com.example.EffectiveDataTransfer.RDB.Entity.Event;
import com.example.EffectiveDataTransfer.RDB.Entity.Task;

public class CreateTaskEvent {

    public static Event of(Task task) {
        return Event.builder()
                .status(0)
                .payload(task.getTask_content())
                .build();
    }
}
