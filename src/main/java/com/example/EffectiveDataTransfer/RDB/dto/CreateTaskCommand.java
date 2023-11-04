package com.example.EffectiveDataTransfer.RDB.dto;

import com.example.EffectiveDataTransfer.RDB.Entity.Task;
import lombok.Data;

@Data
public class CreateTaskCommand {

    String command;

    public Task toTask() {
        return Task.builder()
                .task_name("task_name")
                .task_content("content")
                .build();
    }
}
