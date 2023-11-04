package com.example.EffectiveDataTransfer.RDB.Service;

import com.example.EffectiveDataTransfer.RDB.Entity.Task;
import com.example.EffectiveDataTransfer.RDB.Handler.EventHandler;
import com.example.EffectiveDataTransfer.RDB.dto.CreateTaskResponse;
import com.example.EffectiveDataTransfer.RDB.Repository.EventRepository;
import com.example.EffectiveDataTransfer.RDB.Repository.TaskRepository;
import com.example.EffectiveDataTransfer.RDB.dto.CreateTaskCommand;
import com.example.EffectiveDataTransfer.RDB.dto.CreateTaskEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateTaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EventRepository eventRepository;

    private EventHandler eventHandler;

    @Transactional
    public CreateTaskResponse createTask(CreateTaskCommand createTaskCommand) {

        Task task = createTaskCommand.toTask();
        taskRepository.save(task); // Save task Entity
        eventRepository.save(CreateTaskEvent.of(task));
        //eventHandler.propagate(CreateTaskEvent.of(task));
        return CreateTaskResponse.of(task);
    }

}
