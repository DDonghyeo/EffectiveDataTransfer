package com.example.EffectiveDataTransfer.dto;

import com.example.EffectiveDataTransfer.Entity.Task;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateTaskResponse {

    private String content;

    public static CreateTaskResponse of(Task task) {
        return new CreateTaskResponse(task.getTask_name());
    }
}
