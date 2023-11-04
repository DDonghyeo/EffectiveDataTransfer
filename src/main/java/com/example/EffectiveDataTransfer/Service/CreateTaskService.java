package com.example.EffectiveDataTransfer.Service;

import com.example.EffectiveDataTransfer.Entity.Task;
import com.example.EffectiveDataTransfer.Handler.EventHandler;
import com.example.EffectiveDataTransfer.Repository.TaskRepository;
import com.example.EffectiveDataTransfer.dto.CreateTaskCommand;
import com.example.EffectiveDataTransfer.dto.CreateTaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateTaskService {

    @Autowired
    private TaskRepository taskRepository;

    private EventHandler eventHandler;

    @Transactional
    public CreateTaskResponse createTask(CreateTaskCommand createTaskCommand) {

        System.out.println("Create Task ...");
        Task task = createTaskCommand.toTask();

        System.out.println("Save Task ...");
        taskRepository.save(task); // Save task Entity

        eventHandler.propagate(CreateTaskEvent.of(task)); // REST-API (Another Component)
        return CreateTaskResponse.of(task);
    }

}
